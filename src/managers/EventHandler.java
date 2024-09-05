package managers;

import data.events.ButtonEvent;
import data.events.DeckListener;
import data.events.FaderEvent;
import obj.Button;
import obj.DeckPoint;
import obj.Fader;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import java.util.ArrayList;
import java.util.List;

public class EventHandler implements Receiver {

    private final List<DeckListener> listeners = new ArrayList<>();
    public void registerListener(DeckListener listener) {
        listeners.add(listener);
    }

    public void unregisterListeners() {
        listeners.clear();
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        final byte[] msg = message.getMessage();
        final int deckObjAction = msg[0];
        final int deckObj = msg[1];
        final int deckObjValue = msg[2];

        if(deckObjAction == -80) {
            final Fader fader = ButtonManager.getFader(new DeckPoint(deckObj));
            fader.setValue(deckObjValue);
            listeners.forEach(l -> l.onFader(new FaderEvent(fader)));
            return;
        }
        final boolean down = deckObjAction == -112;
        final Button button = ButtonManager.getButton(new DeckPoint(deckObj));
        button.setDown(down);
        listeners.forEach(l -> l.onButton(new ButtonEvent(button, down)));
    }

    @Override
    public void close() {
        unregisterListeners();
    }
}

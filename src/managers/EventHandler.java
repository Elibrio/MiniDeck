package managers;

import data.events.ButtonEvent;
import data.events.DeckListener;
import data.events.FaderEvent;
import obj.Button;
import obj.DeckPoint;

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
            listeners.forEach(l -> l.onFader(new FaderEvent(deckObj, deckObjValue)));
            return;
        }
        listeners.forEach(l -> l.onButton(new ButtonEvent(new Button(new DeckPoint(deckObj)), deckObjValue == -112)));
    }

    @Override
    public void close() {
        unregisterListeners();
        close();
    }
}

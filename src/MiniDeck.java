
import data.Color;
import managers.EventHandler;
import obj.Button;
import util.MidiUtil;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;

public class MiniDeck {

    private MidiDevice deckIn;
    private MidiDevice deckOut;
    private EventHandler eventHandler;

    public MiniDeck() throws MidiUnavailableException {
        for (MidiDevice deckDevice : MidiUtil.getMidiDevices("mini")) {
            try {
                deckDevice.getReceiver();
                deckIn = deckDevice;
            } catch (MidiUnavailableException e) {
                deckOut = deckDevice;
            }
        }

        if(deckIn == null) {
            System.out.println("No deck input found!");
            return;
        }

        System.out.println("Deck input found!");

        if(deckOut == null) {
            System.out.println("No deck output found!");
            return;
        }

        System.out.println("Deck output found!");
        System.out.println("Starting...");

        deckIn.open();
        deckOut.open();

        eventHandler = new EventHandler();
        deckOut.getTransmitter().setReceiver(eventHandler);
    }

    public void send(Button b, Color color) {
        send(b, color, -1);
    }

    public void send(Button b, Color color, int timestamp){
        final ShortMessage msg = new ShortMessage();
        try {
            msg.setMessage(ShortMessage.NOTE_ON, 0, b.getPoint().getValue(), color.getColor());
            deckIn.getReceiver().send(msg, timestamp);
        } catch (InvalidMidiDataException | MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }
}
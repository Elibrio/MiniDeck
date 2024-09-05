package main;

import managers.ButtonManager;
import managers.EventHandler;
import obj.Button;
import util.MidiUtil;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;

public class MiniDeck {

    private static MiniDeck instance;

    private MidiDevice deckIn;
    private MidiDevice deckOut;
    private EventHandler eventHandler;

    public MiniDeck() throws MidiUnavailableException {
        instance = this;
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

        ButtonManager.resetButtons();
    }

    public void send(Button b) {
        send(b, -1);
    }

    public void send(Button b, int timestamp){
        final ShortMessage msg = new ShortMessage();
        try {
            msg.setMessage(ShortMessage.NOTE_ON, 0, b.getPoint().getValue(), b.getColor().getValue());
            deckIn.getReceiver().send(msg, timestamp);
        } catch (InvalidMidiDataException | MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public static MiniDeck getInstance() {
        return instance;
    }
}
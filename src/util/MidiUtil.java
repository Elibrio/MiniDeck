package util;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;
import java.util.List;

public class MidiUtil {

    private MidiUtil() {}

    public static List<MidiDevice> getMidiDevices(String namePart) {
        final List<MidiDevice> devices = new ArrayList<>();
        for (MidiDevice.Info deviceInfo : MidiSystem.getMidiDeviceInfo()) {
            if(!deviceInfo.getName().toLowerCase().contains(namePart)) continue;
            try {
                devices.add(MidiSystem.getMidiDevice(deviceInfo));
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
        }
        return devices;
    }

}

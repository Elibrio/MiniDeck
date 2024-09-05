package managers;

import obj.Button;
import obj.DeckPoint;
import obj.Fader;

import java.util.ArrayList;
import java.util.List;

public class ButtonManager {
    private static final List<Button> buttons = new ArrayList<>();
    private static final List<Fader> faders = new ArrayList<>();

    public static Fader getFader(DeckPoint deckPoint){
        for (Fader f : faders){
            if(f.getPoint().getValue() == deckPoint.getValue()){
                return f;
            }
        }
        faders.add(new Fader(deckPoint));
        return getFader(deckPoint);
    }
    public static Button getButton(DeckPoint deckPoint){
        for(Button b : buttons){
            if(b.getPoint().getValue() == deckPoint.getValue()){
                return b;
            }
        }
        buttons.add(new Button(deckPoint));
        return getButton(deckPoint);
    }
}

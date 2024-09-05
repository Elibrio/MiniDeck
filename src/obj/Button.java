package obj;

import data.ButtonType;
import data.Color;
import main.MiniDeck;

public class Button {
    private final DeckPoint point;
    private final ButtonType buttonType;
    private Color color = Color.GREEN;
    private boolean down = false;


    public Button(DeckPoint point) {
        this.point = point;
        this.buttonType = point.getValue() > 64 ? ButtonType.SPECIAL : ButtonType.FIELD;
    }

    public DeckPoint getPoint() {
        return point;
    }

    public ButtonType getButtonType() {
        return buttonType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        MiniDeck.getInstance().send(this);
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}

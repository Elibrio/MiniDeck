package obj;

import data.ButtonState;
import data.ButtonType;
import data.Color;

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

    }

    public ButtonState getButtonState() {
        return buttonState;
    }

    public void setButtonState(ButtonState buttonState) {
        this.buttonState = buttonState;
    }
}

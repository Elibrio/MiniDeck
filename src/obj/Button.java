package obj;

import data.ButtonClickType;
import data.ButtonState;
import data.ButtonType;
import data.Color;

public class Button {
    private final DeckPoint point;
    private final ButtonType buttonType;
    private Color color = Color.GREEN;
    private ButtonClickType clickType = ButtonClickType.HOLD;
    private ButtonState buttonState = ButtonState.INACTIVE;

    private int holdTime = 0;
    private int coolDown = 0;

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

    public ButtonClickType getClickType() {
        return clickType;
    }

    public void setClickType(ButtonClickType clickType) {
        this.clickType = clickType;
    }

    public ButtonState getButtonState() {
        return buttonState;
    }

    public void setButtonState(ButtonState buttonState) {
        this.buttonState = buttonState;
    }

    public int getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(int holdTime) {
        this.holdTime = holdTime;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }
}

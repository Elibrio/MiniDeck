package data;

public enum ButtonState {
    UNUSED(Color.OFF), // When is not used
    ACTIVE(Color.GREEN), // When is on
    INACTIVE(Color.RED), // When is off
    STILL_ACTIVE(Color.YELLOW), // When is on but will turn off
    COOL_DOWN(Color.YELLOW), // When can't use but soon can
    DEACTIVATED(Color.RED_PULSE), // When can't use
    SHOULD_USE(Color.GREEN_PULSE); // When Should be used
    private Color color;
    private ButtonState(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

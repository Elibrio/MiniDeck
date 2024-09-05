package data;

import java.util.Arrays;

public enum Color {
    OFF (0),
    GREEN(1),
    GREEN_PULSE(2),
    RED(3),
    RED_PULSE(4),
    YELLOW(5),
    YELLOW_PULSE(6);

    private final int color;

    Color(int color){
        this.color = color;
    }

    public static Color getValue(int color){
        return Arrays.stream(values()).filter(c -> c.color == color).findFirst().orElse(Color.OFF);
    }
    public int getValue() {
        return color;
    }
}

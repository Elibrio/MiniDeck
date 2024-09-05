package obj;

public class DeckPoint{

    private final int x;
    private final int y;

    private final int value;

    public DeckPoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = (y * 8) + x;
    }

    public DeckPoint(int value) {
        this.y = value / 8;
        this.x = value % 8;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }
}

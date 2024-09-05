package obj;

public class Fader {
    private int value;
    private final DeckPoint point;

    public Fader(DeckPoint point){
        this.value = 0;
        this.point = point;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public DeckPoint getPoint() {
        return point;
    }
}

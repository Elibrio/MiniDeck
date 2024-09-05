package data.events;

public interface DeckListener {

    default void onButton(ButtonEvent event) {}

    default void onFader(FaderEvent event) {}

}

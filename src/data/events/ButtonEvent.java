package data.events;

import obj.Button;

public record ButtonEvent(Button button, boolean down) {}

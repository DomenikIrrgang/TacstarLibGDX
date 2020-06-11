package de.syncup.tacstar.eventbus;

public abstract class DispatchedEvent {

    protected Event event;

    public DispatchedEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }
}

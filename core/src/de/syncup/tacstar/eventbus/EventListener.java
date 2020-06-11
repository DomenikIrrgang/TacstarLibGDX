package de.syncup.tacstar.eventbus;

public interface EventListener<T extends DispatchedEvent> {
    void onEvent(Event event, Object ... args);
}

package de.syncup.tacstar.eventbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {

    private Map<Event, List<EventListener>> listener = new HashMap<>();
    private static EventBus instance = new EventBus();

    private EventBus() {}

    public static EventBus getInstance() {
        return EventBus.instance;
    }

    public void addEventListener(Event event, EventListener listener) {
        if (this.listener.get(event) == null)
            this.listener.put(event, new ArrayList<EventListener>());
        this.listener.get(event).add(listener);
    }

    public void removeEventListener(Event event, EventListener listener) {
        if (this.listener.get(event) != null) {
            this.listener.get(event).remove(listener);
        }
    }

    public void dispatchEvent(Event event, Object ... arguments) {
        if (this.listener.get(event) != null)
            for (EventListener listener : this.listener.get(event))
                listener.onEvent(event, arguments);
    }
}

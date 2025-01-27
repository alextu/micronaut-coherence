package io.micronaut.coherence.data.util;

import io.micronaut.coherence.data.model.Book;
import io.micronaut.context.annotation.Any;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Any
public class EventRecorder<T> {

    private final List<EventRecord<T>> eventRecords = new ArrayList<>();

    public void record(EventType eventType, T entity) {
        eventRecords.add(new EventRecord<>(eventType, entity));
    }

    public void reset() {
        eventRecords.clear();
    }

    public List<EventRecord<T>> getRecordedEvents() {
        return eventRecords;
    }
}

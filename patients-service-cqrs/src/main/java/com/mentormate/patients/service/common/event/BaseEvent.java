package com.mentormate.patients.service.common.event;

/**
 * @author Shedrack Chiedozie Aji
 **/
public class BaseEvent<T> {

    private final T id;

    public BaseEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}

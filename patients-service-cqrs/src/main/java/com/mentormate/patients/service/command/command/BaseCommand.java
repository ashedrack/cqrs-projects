package com.mentormate.patients.service.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author Shedrack Chiedozie Aji
 **/
public class BaseCommand<T> {

    @TargetAggregateIdentifier
    private final T id;

    public BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}

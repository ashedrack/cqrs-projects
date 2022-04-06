package com.mentormate.patients.service.common.event;

/**
 * @author Shedrack Chiedozie Aji
 **/
public class PatientActivatedEvent extends BaseEvent<String> {

    private final String status;

    public PatientActivatedEvent(String id, String status) {
        super(id);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

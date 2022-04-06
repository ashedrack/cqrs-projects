package com.mentormate.patients.service.common.event;

/**
 * @author Shedrack Chiedozie Aji
 **/
public class PatientsEvent extends BaseEvent<String> {

    private final String status;
    private final String patientId;

    public PatientsEvent(String id, String status, String patientId) {
        super(id);
        this.status = status;
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }
}

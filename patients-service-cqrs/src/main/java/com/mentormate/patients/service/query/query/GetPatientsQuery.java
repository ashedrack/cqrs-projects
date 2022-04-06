package com.mentormate.patients.service.query.query;

import lombok.Data;

@Data
public class GetPatientsQuery {

    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
    private String status;

    public GetPatientsQuery(String patientId, String name, String age, String address, String phoneNumber, String status) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public GetPatientsQuery() {

    }
}

package com.baseproject.PatientService.command.api.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Builder
public class UpdatePatientRequest {

//    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
}

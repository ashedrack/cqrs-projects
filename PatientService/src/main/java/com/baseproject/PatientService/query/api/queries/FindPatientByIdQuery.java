package com.baseproject.PatientService.query.api.queries;

import lombok.Data;

@Data
public class FindPatientByIdQuery {

    private String patientId;

    public FindPatientByIdQuery(String patientId) {
        this.patientId = patientId;
    }
}

package com.mentormate.patients.service.query.query;

import lombok.Data;

/**
 * @author Shedrack Chiedozie Aji
 **/
@Data
public class FindAccountByIdQuery {
    private String patientId;

    public FindAccountByIdQuery(String patientId) {
        this.patientId = patientId;
    }
}

package com.baseproject.PatientService.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class PatientInfo {

    @Id
    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
}

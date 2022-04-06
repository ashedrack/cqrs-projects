package com.baseproject.PatientService.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Patient {
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
}

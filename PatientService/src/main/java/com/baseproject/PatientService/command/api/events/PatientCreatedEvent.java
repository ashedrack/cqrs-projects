package com.baseproject.PatientService.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientCreatedEvent {

    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
}

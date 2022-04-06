package com.baseproject.PatientService.command.api.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientUpdatedEvent {

    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
}

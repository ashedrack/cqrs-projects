package com.baseproject.PatientService.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreatePatientCommand {

    @TargetAggregateIdentifier
    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;

//    public CreatePatientCommand apply(PatientCreatedEvent patientCreatedEvent){
//        return  null;
//    }
}

package com.baseproject.PatientService.command.api.aggregate;

import com.baseproject.PatientService.command.api.commands.CreatePatientCommand;
import com.baseproject.PatientService.command.api.commands.UpdatePatientCommand;
import com.baseproject.PatientService.command.api.events.PatientCreatedEvent;
import com.baseproject.PatientService.command.api.events.PatientUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class PatientAggregate {

    @AggregateIdentifier
    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;

    public PatientAggregate() {
    }

    @CommandHandler
    public PatientAggregate(CreatePatientCommand createPatientCommand) {
        PatientCreatedEvent patientCreatedEvent = new PatientCreatedEvent();
        BeanUtils.copyProperties(createPatientCommand, patientCreatedEvent);
        AggregateLifecycle.apply(patientCreatedEvent);
    }


    @EventSourcingHandler
    public void on(PatientCreatedEvent patientCreatedEvent) {
        this.age = patientCreatedEvent.getAge();
        this.patientId = patientCreatedEvent.getPatientId();
        this.address = patientCreatedEvent.getAddress();
        this.phoneNumber = patientCreatedEvent.getPhoneNumber();
        this.name = patientCreatedEvent.getName();
    }



}

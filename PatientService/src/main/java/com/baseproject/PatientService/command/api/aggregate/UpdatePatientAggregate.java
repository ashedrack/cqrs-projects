package com.baseproject.PatientService.command.api.aggregate;

import com.baseproject.PatientService.command.api.commands.UpdatePatientCommand;
import com.baseproject.PatientService.command.api.events.PatientUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UpdatePatientAggregate {

    @AggregateIdentifier
    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;

    public UpdatePatientAggregate() {
    }

    @CommandHandler
    public void on(UpdatePatientCommand updatePatientCommand) {
        PatientUpdatedEvent patientUpdatedEvent =
                new PatientUpdatedEvent();
        BeanUtils.copyProperties(updatePatientCommand, patientUpdatedEvent);
        AggregateLifecycle.apply(patientUpdatedEvent);
    }

    @EventSourcingHandler
    public void on(PatientUpdatedEvent patientUpdatedEvent) {
        this.age = patientUpdatedEvent.getAge();
        this.patientId = patientUpdatedEvent.getPatientId();
        this.address = patientUpdatedEvent.getAddress();
        this.phoneNumber = patientUpdatedEvent.getPhoneNumber();
        this.name = patientUpdatedEvent.getName();
    }
}

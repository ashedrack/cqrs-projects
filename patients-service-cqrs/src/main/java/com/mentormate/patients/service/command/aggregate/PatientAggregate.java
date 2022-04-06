package com.mentormate.patients.service.command.aggregate;

import com.mentormate.patients.service.command.command.CreatePatientCommand;
import com.mentormate.patients.service.command.command.UpdatePatientCommand;
import com.mentormate.patients.service.common.event.PatientActivatedEvent;
import com.mentormate.patients.service.common.event.PatientUpdateEvent;
import com.mentormate.patients.service.common.event.PatientsEvent;
import com.mentormate.patients.service.common.event.PatientCreatesEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * @author Shedrack Chiedozie Aji
 **/

@Aggregate
@Slf4j
public class PatientAggregate {

    @AggregateIdentifier
    private String patientId;
    private String name;
    private String age;
    private String address;
    private String phoneNumber;
    private String status;

    public PatientAggregate() {
    }

    @CommandHandler
    public PatientAggregate(CreatePatientCommand createPatientCommand) {
        log.info("Patient record received.");
        AggregateLifecycle.apply(new PatientCreatesEvent(
                createPatientCommand.getId(),
                createPatientCommand.getName(),
                createPatientCommand.getAge(),
                createPatientCommand.getAddress(),
                createPatientCommand.getPhoneNumber()

                ));
    }

    @EventSourcingHandler
    public void on(PatientCreatesEvent patientCreatesEvent) {
        log.info("Account creation occurred.....");
        this.patientId = patientCreatesEvent.getId();
        this.age = patientCreatesEvent.getAge();
        this.address = patientCreatesEvent.getAddress();
        this.phoneNumber = patientCreatesEvent.getName();
        this.phoneNumber = patientCreatesEvent.getPhoneNumber();
        this.status = "CREATED";
        AggregateLifecycle.apply(new PatientsEvent(this.patientId, "ACTIVATED", patientId));
    }

    @EventSourcingHandler
    public void on(PatientActivatedEvent patientActivatedEvent) {
        log.info("An AccountActivatedEvent occurred.");
        this.status = patientActivatedEvent.getStatus();
    }

    @CommandHandler
    public void on(UpdatePatientCommand updatePatientCommand) {
        log.info("record  updated....");
        AggregateLifecycle.apply(new PatientUpdateEvent(
                updatePatientCommand.getId(),
                updatePatientCommand.getName(),
                updatePatientCommand.getAge(),
                updatePatientCommand.getAddress(),
                updatePatientCommand.getPhoneNumber()

    ));
    }

}

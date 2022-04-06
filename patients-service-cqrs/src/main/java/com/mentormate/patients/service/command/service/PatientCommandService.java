package com.mentormate.patients.service.command.service;

import com.mentormate.patients.service.command.command.CreatePatientCommand;
import com.mentormate.patients.service.command.command.UpdatePatientCommand;
import com.mentormate.patients.service.command.dto.CreatePatientRequest;
import com.mentormate.patients.service.command.dto.UpdatePatientRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @author Shedrack Chiedozie Aji
 **/

@Service
public class PatientCommandService {

    private final CommandGateway commandGateway;

    public PatientCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<Object> registerPatient(CreatePatientRequest createPatientRequest) {
        return commandGateway.send(new CreatePatientCommand(
                        UUID.randomUUID().toString(),
                        createPatientRequest.getName(),
                        createPatientRequest.getAge(),
                        createPatientRequest.getAddress(),
                        createPatientRequest.getPhoneNumber()
        ));

    }

    public CompletableFuture<String> updatePatient(UpdatePatientRequest updatePatientRequest) {
        return commandGateway.send(new UpdatePatientCommand(
                updatePatientRequest.getPatientId(),
                updatePatientRequest.getName(),
                updatePatientRequest.getAge(),
                updatePatientRequest.getAddress(),
                updatePatientRequest.getPhoneNumber()

        ));
    }


}

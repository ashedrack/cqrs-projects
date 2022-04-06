package com.mentormate.patients.service.command.controller;

import com.mentormate.patients.service.command.dto.BaseResponse;
import com.mentormate.patients.service.command.dto.CreatePatientRequest;
import com.mentormate.patients.service.command.dto.UpdatePatientRequest;
import com.mentormate.patients.service.command.service.PatientCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * @author Shedrack Chiedozie Aji
 **/
@RestController
@RequestMapping(value = "/patients")
public class PatientCommandController {

    private final PatientCommandService patientCommandService;

    public PatientCommandController(PatientCommandService patientCommandService) {
        this.patientCommandService = patientCommandService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerPatient(@RequestBody CreatePatientRequest createPatientRequest) {
        try {
            CompletableFuture<Object> response =
                    patientCommandService.registerPatient(createPatientRequest);

            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @PutMapping(value = "/update-patient")
//    public ResponseEntity<String> updatePatient(@RequestBody UpdatePatientRequest updatePatientRequest) {
//        try {
//            patientCommandService.updatePatient(updatePatientRequest);
//
//            return new ResponseEntity<>("Your record is updated", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }



}

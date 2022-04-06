package com.mentormate.patients.service.query.controller;

import com.mentormate.patients.service.command.entity.Patient;
import com.mentormate.patients.service.query.query.FindAccountByIdQuery;
import com.mentormate.patients.service.query.query.GetPatientsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Shedrack Chiedozie Aji
 **/
@RestController
@RequestMapping(value = "/manage-patients")
public class PatientQueryController {

    private final QueryGateway queryGateway;

    public PatientQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public ResponseEntity<Patient> getPatient(@RequestParam String patientId) {
        Patient patient = queryGateway.query(
                new FindAccountByIdQuery(patientId), Patient.class
        ).join();

        if (patient == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }


    @GetMapping("/all")
    public List<Patient> getAllPatients() throws Exception {
        GetPatientsQuery getPatientsQuery = new GetPatientsQuery();

        List<Patient> patientQueryModel =
                queryGateway.query(getPatientsQuery,
                                ResponseTypes.multipleInstancesOf(Patient.class))
                        .join();

        if (patientQueryModel == null) {
            throw new Exception("No patient found");
        }

        return patientQueryModel;
    }



}

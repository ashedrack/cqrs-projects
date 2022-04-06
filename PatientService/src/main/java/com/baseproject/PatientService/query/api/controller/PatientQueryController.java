package com.baseproject.PatientService.query.api.controller;

import com.baseproject.PatientService.command.api.data.PatientInfo;
import com.baseproject.PatientService.command.api.model.Patient;
import com.baseproject.PatientService.query.api.queries.FindPatientByIdQuery;
import com.baseproject.PatientService.query.api.queries.GetPatientsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientQueryController {

    private QueryGateway queryGateway;

    public PatientQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
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


    @GetMapping("/get-patient")
    public ResponseEntity<PatientInfo> getPatient(@RequestParam String patientId) {
        PatientInfo PatientInfo = queryGateway.query(
                new FindPatientByIdQuery(patientId), PatientInfo.class
        ).join();

        if (PatientInfo == null) {
            return new ResponseEntity ( "Sorry, something has gone wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity (PatientInfo, HttpStatus.OK);
    }
}

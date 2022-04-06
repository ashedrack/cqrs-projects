package com.mentormate.patients.service.query.service;

import com.mentormate.patients.service.command.entity.Patient;
import com.mentormate.patients.service.command.repository.PatientRepository;
import com.mentormate.patients.service.common.event.PatientActivatedEvent;
import com.mentormate.patients.service.common.event.PatientCreatesEvent;
import com.mentormate.patients.service.common.event.PatientUpdateEvent;
import com.mentormate.patients.service.query.query.FindAccountByIdQuery;
import com.mentormate.patients.service.query.query.GetPatientsQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shedrack Chiedozie Aji
 **/

@Service
@Slf4j
public class PatientQueryService {

    private final PatientRepository patientQueryRepository;

    public PatientQueryService(PatientRepository patientQueryRepository) {
        this.patientQueryRepository = patientQueryRepository;
    }

    @EventHandler
    public void on(PatientCreatesEvent patientCreatesEvent) {
        log.info("Handling patient creation...");
        Patient patient = new Patient();
        patient.setPatientId(patientCreatesEvent.getId());
        patient.setPhoneNumber(patientCreatesEvent.getPhoneNumber());
        patient.setName(patientCreatesEvent.getName());
        patient.setAddress(patientCreatesEvent.getAddress());
        patient.setAge(patientCreatesEvent.getAge());
        patient.setStatus("CREATED");
        patientQueryRepository.save(patient);
    }

    @EventHandler
    public void on(PatientUpdateEvent patientUpdateEvent) {
        log.info("Handling patient creation...");
        Patient patient = new Patient();
        patient.setPatientId(patientUpdateEvent.getId());
        patient.setPhoneNumber(patientUpdateEvent.getPhoneNumber());
        patient.setName(patientUpdateEvent.getName());
        patient.setAddress(patientUpdateEvent.getAddress());
        patient.setAge(patientUpdateEvent.getAge());
        patient.setStatus("CREATED");
        patientQueryRepository.save(patient);
    }

    @QueryHandler
    public Patient handle(FindAccountByIdQuery query) {
        log.info("Handling FindAccountByIdQuery...");
        Patient patient = patientQueryRepository
                .findById(query.getPatientId()).orElse(null);

        return patient;
    }

    @QueryHandler
    public List<Patient> handle(GetPatientsQuery query) {
        List<Patient> patient;
        patient = (List<Patient>)
               patientQueryRepository.findAll();

        return patient;
    }

    @EventHandler
    public void on(PatientActivatedEvent patientActivatedEvent) {
        log.info("Handling PatientActivatedEvent...");
        Patient patient = patientQueryRepository.findById(patientActivatedEvent.getId()).orElse(null);

        if (patient != null) {
            patient.setStatus(patientActivatedEvent.getStatus());
            patientQueryRepository.save(patient);
        }
    }

}

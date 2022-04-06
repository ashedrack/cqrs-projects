package com.baseproject.PatientService.query.api.projection;

import com.baseproject.PatientService.command.api.data.PatientInfo;
import com.baseproject.PatientService.command.api.data.PatientRepository;
import com.baseproject.PatientService.command.api.model.Patient;
import com.baseproject.PatientService.query.api.queries.FindPatientByIdQuery;
import com.baseproject.PatientService.query.api.queries.GetPatientsQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PatientProjection {

    private PatientRepository patientRepository;

    public PatientProjection(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @QueryHandler
    public List<Patient> handle(GetPatientsQuery getProductsQuery) {
        List<PatientInfo> patients =
                patientRepository.findAll();

        List<Patient> patientsProjections =
                patients.stream()
                        .map(patientInfo -> Patient
                                .builder()
                                .age(patientInfo.getAge())
                                .address(patientInfo.getAddress())
                                .name(patientInfo.getName())
                                .phoneNumber(patientInfo.getPhoneNumber())
                                .build())
                        .collect(Collectors.toList());

        return patientsProjections;
    }

    @QueryHandler
    public PatientInfo handle(FindPatientByIdQuery query) {
        log.info("Handling FindAccountByIdQuery...");
        PatientInfo patientInfo = patientRepository
                .findById(query.getPatientId()).orElse(null);

        return patientInfo;
    }
}

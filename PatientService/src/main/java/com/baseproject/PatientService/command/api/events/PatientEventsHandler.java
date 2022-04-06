package com.baseproject.PatientService.command.api.events;

import com.baseproject.PatientService.command.api.data.PatientInfo;
import com.baseproject.PatientService.command.api.data.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("patients")
@Slf4j
public class PatientEventsHandler {

    private PatientRepository patientRepository;

    public PatientEventsHandler(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @EventHandler
    public void on(PatientCreatedEvent event) throws Exception {
        PatientInfo patientInfo = new PatientInfo();
        BeanUtils.copyProperties(event,patientInfo);
        patientRepository.save(patientInfo);

    }


}

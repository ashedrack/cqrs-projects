package com.baseproject.PatientService.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientInfo,String> {
}

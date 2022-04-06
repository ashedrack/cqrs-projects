package com.mentormate.patients.service.command.repository;

import com.mentormate.patients.service.command.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shedrack Chiedozie Aji
 **/
@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
}

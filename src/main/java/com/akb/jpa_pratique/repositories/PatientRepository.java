package com.akb.jpa_pratique.repositories;

import com.akb.jpa_pratique.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

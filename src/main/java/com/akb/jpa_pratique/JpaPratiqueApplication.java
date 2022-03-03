package com.akb.jpa_pratique;

import com.akb.jpa_pratique.entities.Patient;
import com.akb.jpa_pratique.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaPratiqueApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaPratiqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (int i = 0; i< 100; i++){
			patientRepository.save(new Patient(null, "nomPatient_"+i, new Date(), false, (int)(Math.random()*100)));
		}

		List<Patient> patients = patientRepository.findAll();
		patients.forEach(p -> {
			System.out.println("<==============================>");
			System.out.println(p.getId());
			System.out.println(p.getNom());
			System.out.println(p.getScore());
			System.out.println(p.getDateNaissance());
			System.out.println(p.isMalade());
		});

		System.out.println("<====TROUVER LES PATIENT DONT ID=1 ====>");
		Patient patient = patientRepository.findById(1L).orElse(null);
		if (patient != null){
			System.out.println(patient.getNom());
			System.out.println(patient.isMalade());
		}

		System.out.println("<==== MODIFIER LE SCORE DU PATIENT ====>");
		patient.setScore(856);
		patientRepository.save(patient);

		System.out.println("<==== SUPPRIMER LE PATIENT DONT L'ID=1 ====>");
		patientRepository.deleteById(1L);


	}
}
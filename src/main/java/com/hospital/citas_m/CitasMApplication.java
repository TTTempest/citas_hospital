package com.hospital.citas_m;

import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.entities.Diagnostico;
import com.hospital.citas_m.repositories.CitaRepositorio;
import com.hospital.citas_m.repositories.DiagnosticoRepositorio;
import jakarta.persistence.Id;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CitasMApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitasMApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CitaRepositorio citaRepository, DiagnosticoRepositorio diagnosticoRepositorio){
		return args->{
			Cita cita=new Cita();
			cita.setFechaHora(LocalDate.now());
			cita.setMotivoCita("operacion");
			cita.setAttribute11(111);
			Diagnostico dia=new Diagnostico();
			dia.setValoracionEspecialidad("leve");
			dia.setEnfermedad("fiebre");
			cita.setDiagnostico(dia);
			citaRepository.save(cita);
			diagnosticoRepositorio.save(dia);
			Cita cita2 =citaRepository.findCitaById(1l);
			System.out.println(cita2.toString());
		};

	}
}

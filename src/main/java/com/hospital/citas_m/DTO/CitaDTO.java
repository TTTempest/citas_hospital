package com.hospital.citas_m.DTO;

import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.entities.Paciente;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor

public class CitaDTO {
    private Long id;
    private LocalDate fecha;

    private String motivoCita;

    private int attribute11;

    public CitaDTO(Long id, LocalDate fecha, String motivoCita, int attribute11) {
        this.id = id;
        this.fecha = fecha;
        this.motivoCita = motivoCita;
        this.attribute11 = attribute11;
    }

}


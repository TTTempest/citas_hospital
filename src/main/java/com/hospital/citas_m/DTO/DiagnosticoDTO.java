package com.hospital.citas_m.DTO;

import com.hospital.citas_m.entities.Diagnostico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticoDTO {
    private Long id;

    private String valoracionEspecialidad;

    private String enfermedad;

    private CitaDtoRcort cita;


}



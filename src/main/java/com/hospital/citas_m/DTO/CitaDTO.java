package com.hospital.citas_m.DTO;


import com.hospital.citas_m.entities.Cita;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO {
    private Long id;
    private LocalDate fechaHora;
    private String motivoCita;
    private PacienteDTO paciente;
    private MedicoDTORcort medico;
    private DiagnosticoDtoRcort diagnostico;

}

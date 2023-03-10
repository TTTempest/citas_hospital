package com.hospital.citas_m.DTO;

import com.hospital.citas_m.entities.Diagnostico;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiagnosticoDTO {
    private Long id;

    private String valoracionEspecialidad;

    private String enfermedad;

    public DiagnosticoDTO(Diagnostico diagnostico) {
        this.id = diagnostico.getId();
        this.valoracionEspecialidad = diagnostico.getValoracionEspecialidad();
        this.enfermedad = diagnostico.getEnfermedad();
    }


}



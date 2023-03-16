package com.hospital.citas_m.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PacienteDTO extends UsuarioDTO {
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    private List<CitaDtoRcort> citas;
    private List<MedicoDTORcort> medico;
}

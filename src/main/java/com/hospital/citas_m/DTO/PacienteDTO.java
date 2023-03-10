package com.hospital.citas_m.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteDTO extends UsuarioDTO {
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
}

package com.hospital.citas_m.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private long id;

    private String nombre;

    private String apellidos;

    private String usuario;

    private String clave;
}

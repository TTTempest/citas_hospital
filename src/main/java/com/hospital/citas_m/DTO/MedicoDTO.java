package com.hospital.citas_m.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO extends UsuarioDTO{
    private String numColegiado;

}

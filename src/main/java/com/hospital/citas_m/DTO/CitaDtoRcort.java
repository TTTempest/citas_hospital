package com.hospital.citas_m.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDtoRcort {
    private Long id;
    private LocalDate fecha;
    private String motivoCita;

}

package com.hospital.citas_m.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="diagnostico")
public class Diagnostico {

    @Column(name = "id",nullable = false,unique = true)
    @Id
    @SequenceGenerator(name = "id_diagnostico", sequenceName = "id_diagnostico", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "id_diagnostico")
    private Long id;
    @Column(name = "valoracionEspecialidad",nullable = false,unique = false)
    private String valoracionEspecialidad;
    @Column(name = "enfermedad",nullable = false,unique = false)
    private String enfermedad;

    @OneToOne(mappedBy = "diagnostico")
    private Cita cita;

    public Diagnostico(String valoracionEspecialidad, String enfermedad, Cita cita) {
        this.valoracionEspecialidad = valoracionEspecialidad;
        this.enfermedad = enfermedad;
        this.cita = cita;
    }
}

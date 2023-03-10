package com.hospital.citas_m.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@Table(name="diagnostico")
public class Diagnostico {

    @Column(name = "id",nullable = false,unique = true)
    @Id
    @SequenceGenerator(name = "id_diagnostico", sequenceName = "id_diagnostico", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "id_diagnostico")
    private long id;
    @Column(name = "valoracionEspecialidad",nullable = false,unique = false)
    private String valoracionEspecialidad;
    @Column(name = "efermedad",nullable = false,unique = false)
    private String enfermedad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_id")
    private Cita cita;
}

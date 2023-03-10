package com.hospital.citas_m.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cita")
public class Cita {
    @Column(name = "id",nullable = false,unique = true)
    @Id
    @SequenceGenerator(name = "id_cita", sequenceName = "id_cita", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "id_cita")
    private long id;
    @Column(name = "fecha", nullable = false, unique = true)
    private LocalDate fechaHora;
    @Column(name="motivoCIta", nullable = false, unique = false)
    private String motivoCita;
    @Column(name="attribute11", nullable = true, unique = true)
    private int attribute11;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="id_diagnostico", referencedColumnName = "id")
    private Diagnostico diagnostico;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;

}

package com.hospital.citas_m.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cita")
public class Cita {
    @Column(name = "id",nullable = false,unique = true)
    @Id
    @SequenceGenerator(name = "id_diagnostico", sequenceName = "id_diagnostico", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "id_diagnostico")
    private Long id;
    @Column(name = "fechaHora")
    private LocalDate fechaHora;
    @Column(name="motivoCita")
    private String motivoCita;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="id_diagnostico")
    private Diagnostico diagnostico;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

}

package com.hospital.citas_m.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "medico")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Medico extends Usuario{


    @Column(name = "numColegiado",nullable = false,unique = true)
    private String numColegiado;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Cita> citas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "medico_paciente",
            joinColumns = @JoinColumn(name = "id_medico"),
            inverseJoinColumns = @JoinColumn(name = "id_paciente")
    )
    private Set<Paciente> paciente = new HashSet<>();
    @OneToMany(mappedBy = "medico")
    private Set<Cita> cita = new HashSet<>();

}

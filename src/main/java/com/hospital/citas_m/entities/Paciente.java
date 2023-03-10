package com.hospital.citas_m.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="paciente")
@PrimaryKeyJoinColumn(referencedColumnName = "id")

public class Paciente extends Usuario {
    @Column(name = "NSS", nullable = false, unique = false)
    private String NSS;
    @Column(name = "numTarjeta", nullable = false, unique = true)
    private String numTarjeta;
    @Column(name = "telefono", nullable = true, unique = true)
    private String telefono;
    @Column(name = "direccion", nullable = false, unique = true)
    private String direccion;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cita> citas = new HashSet<>();

    @ManyToMany(mappedBy = "paciente")
    private Set<Medico> medico = new HashSet<>();

}


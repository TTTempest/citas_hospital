package com.hospital.citas_m.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "medico")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Medico extends UsuarioEnt {


    @Column(name = "numColegiado",nullable = true,unique = true)
    private String numColegiado;

    @ManyToMany
    @JoinTable(
            name = "medico_paciente",
            joinColumns = @JoinColumn(name = "id_medico"),
            inverseJoinColumns = @JoinColumn(name = "id_paciente")
    )
    private List<Paciente> paciente;
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Cita> cita;


}

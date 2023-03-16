package com.hospital.citas_m.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="paciente")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Paciente extends UsuarioEnt {
    @Column(name = "NSS")
    private String NSS;
    @Column(name = "numTarjeta", nullable = false, unique = true)
    private String numTarjeta;
    @Column(name = "telefono", nullable = true, unique = true)
    private String telefono;
    @Column(name = "direccion", nullable = false, unique = true)
    private String direccion;

    @OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL)
    private List<Cita> citas;

    @ManyToMany(mappedBy = "paciente")
    private List<Medico> medico;

    public Paciente(String nombre, String apellidos, String usuario, String clave, String NSS, String numTarjeta, String telefono, String direccion, @Nullable List<Cita> citas, @Nullable List<Medico> medico) {
        super(nombre, apellidos, usuario, clave);
        this.NSS = NSS;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
        this.citas = new ArrayList<Cita>();
        this.medico = new ArrayList<Medico>();
    }
}


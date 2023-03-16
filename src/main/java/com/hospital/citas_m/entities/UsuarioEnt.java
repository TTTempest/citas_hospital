package com.hospital.citas_m.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "usuario")
public class UsuarioEnt {
    @Column(name = "id", nullable = false, unique = true )
    @Id
    @SequenceGenerator(name = "id_user", sequenceName = "id_user", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "id_user")
    private Long id;

    @Column(name = "nombre", nullable = true, unique = false )
    private String nombre;
    @Column(name = "apellidos", nullable = true, unique = false )
    private String apellidos;
    @Column(name = "usuario", nullable = true, unique = true )
    private String usuario;
    @Column(name = "clave", nullable = true, unique = false )
    private String clave;

    public UsuarioEnt(String nombre, String apellidos, String usuario, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
    }
}



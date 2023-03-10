package com.hospital.citas_m.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "usuario")
public class Usuario {
    @Column(name = "id", nullable = false, unique = true )
    @Id
    @SequenceGenerator(name = "id_user", sequenceName = "id_user", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "id_user")
    private long id;

    @Column(name = "nombre", nullable = false, unique = false )
    private String nombre;
    @Column(name = "apellidos", nullable = false, unique = false )
    private String apellidos;
    @Column(name = "usuario", nullable = false, unique = true )
    private String usuario;
    @Column(name = "clave", nullable = false, unique = false )
    private String clave;



}



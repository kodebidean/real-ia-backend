package com.real_ia.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // Indica que la clase es una entidad
@Table(name = "users") // Nombre de la tabla en la base de datos
@Getter
@Setter // Generar los métodos getter y setter
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los atributos de la clase
@Builder // Crear objetos de la clase sin necesidad de usar el constructor
public class User {

    @Id // Indica que el atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generar el valor automáticamente
    private Long id; // Identificador único del usuario

    @Column(nullable = false, unique = true, length = 255) // Columna no nula y única con longitud de 255 caracteres
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(length = 50, unique = true) // Columna con longitud de 50 caracteres y valores únicos
    private String username;

    @Column(name = "profile_picture_url") // Nombre de la columna en la base de datos
    private String profilePictureUrl;
}

package com.example_project.project.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class ApplicationEntity {

    // id de la aplicacion
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // Nombre de la aplicacion
    private String name;
    // Nombre de la aplicacion
    private String version;
    // se crea la hora automatica
    @CreationTimestamp
    private Date createAt;
    /*
     * 
     * Relacion de muchos a uno
     * 
     */
    @ManyToOne
    @JoinColumn(name = "server_id")

    private ServerEntity server;

}

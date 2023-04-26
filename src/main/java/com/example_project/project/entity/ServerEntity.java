package com.example_project.project.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity

public class ServerEntity {

    // id generada de forma automatica
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // dirección ip del servidor
    private String ip;
    // Memoria del servidor
    private String ram;
    // nombre del servidor
    private String name;
    //
    private String disco;
    // Procesador del servidor
    private String processor;
    // Ubicación del servidor
    private String location;
    // Sistema operativo del servidor
    private String system;
    // se crea la hora automatica
    @CreationTimestamp
    private Date createAt;
    /*
     * 
     * Relacion de uno a muchos
     * 
     */
    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL)
    @JsonManagedReference

    private List<ApplicationEntity> applications;
}

package com.example_project.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseEntity {

    private String code;
    private String message;
    private Object body;
}

package com.example_project.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example_project.project.entity.ApplicationEntity;
import com.example_project.project.repository.ApplicationRepository;

@RestController
@RequestMapping(path = "/api/v1/application")
public class ApplicationController {

    // reliza inyección de instancia
    @Autowired
    private ApplicationRepository applicationRepository;

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public Iterable<ApplicationEntity> getAllaplications() throws Exception {

        return applicationRepository.findAll();

    }

    @RequestMapping(path = "/create-application", method = RequestMethod.POST)
    public ApplicationEntity createApplication(@RequestBody ApplicationEntity applicationEntity) {
        return applicationRepository.save(applicationEntity);
    }

}

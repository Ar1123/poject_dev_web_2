package com.example_project.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example_project.project.entity.ServerEntity;
import com.example_project.project.repository.ServerRepository;

@RestController
@RequestMapping(path = "/api/v1/server")
public class ServerController {

    @Autowired
    private ServerRepository serverRepository;

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public Iterable<ServerEntity> getAllServer() throws Exception {
        return serverRepository.findAll();
    }

    @RequestMapping(path = "/create-server", method = RequestMethod.POST)
    public ServerEntity createServer(@RequestBody ServerEntity serverEntity) throws Exception {
        return serverRepository.save(serverEntity);
    }

}

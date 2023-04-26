package com.example_project.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(path = "/create-server", method = RequestMethod.POST)
    public ServerEntity createServer(@RequestBody ServerEntity serverEntity) throws Exception {
        return serverRepository.save(serverEntity);
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public Iterable<ServerEntity> getAllServer() throws Exception {
        return serverRepository.findAll();
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public Optional<ServerEntity> getAllOne(@PathVariable() Long id) throws Exception {
        return serverRepository.findById(id);
    }

    @RequestMapping(value = "/update/${id}", method = RequestMethod.PUT)
    public ServerEntity update(@RequestBody ServerEntity serverEntity) {
        return serverRepository.save(serverEntity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public boolean delete(@PathVariable() Long id) {
        serverRepository.deleteById(id);
        return true;
    }
}

package se.experis.jesper.microtask4.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.jesper.microtask4.demo.models.Manager;
import se.experis.jesper.microtask4.demo.models.data_access.ManagerRepository;
import java.util.ArrayList;

@RestController
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    @RequestMapping(value = "/api/v1/managers", method = RequestMethod.GET)
    public ArrayList<Manager> getAllManagers() {
        var managers = managerRepository.findAll();
        return (ArrayList<Manager>) managers;
    }

    @RequestMapping(value = "/api/v1/managers", method = RequestMethod.POST)
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        manager = managerRepository.save(manager);
        return new ResponseEntity<>(manager, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/v1/managers", method = RequestMethod.PUT)
    public ResponseEntity<Manager> updateManager(@RequestBody Manager manager) {
        var managerToUpdate = managerRepository.findById(manager.getId()).get();

        managerToUpdate.setId(manager.getId());
        managerToUpdate.setManagerName(manager.getManagerName());
        managerToUpdate.setDob(manager.getDob());
        managerToUpdate.setAddress(manager.getAddress());

        managerRepository.save(managerToUpdate);

        return new ResponseEntity<>(managerToUpdate, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/api/v1/managers/{id}", method = RequestMethod.DELETE)
    public String deleteManager(@PathVariable String id) {
        managerRepository.deleteById(Integer.parseInt(id));
        return "Manager with id number " + id + " is now deleted";

    }
}

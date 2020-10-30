package se.experis.jesper.microtask4.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.jesper.microtask4.demo.models.Candy;
import se.experis.jesper.microtask4.demo.models.data_access.CandyRepository;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CandyController {

    @Autowired
    private CandyRepository candyRepository;

    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.GET)
    public ArrayList<Candy> getAllCandies() {
        var candies = candyRepository.findAll();
        return (ArrayList<Candy>) candies;
    }

    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.POST)
    public ResponseEntity<Candy> createCandy(@RequestBody Candy candy) {
        candy = candyRepository.save(candy);
        return new ResponseEntity<>(candy, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.PUT)
    public ResponseEntity<Candy> updateCandy(@RequestBody Candy candy) {
        var candyToUpdate = candyRepository.findById(candy.getId()).get();

        candyToUpdate.setId(candy.getId());
        candyToUpdate.setName(candy.getName());
        candyToUpdate.setType(candy.getType());
        candyToUpdate.setWeightPerUnit(candy.getWeightPerUnit());
        candyToUpdate.setCostPerUnit(candy.getCostPerUnit());

        candyRepository.save(candyToUpdate);

        return new ResponseEntity<>(candyToUpdate, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/api/v1/candies/{id}", method = RequestMethod.DELETE)
    public String deleteCandy(@PathVariable String id) {
        candyRepository.deleteById(Integer.parseInt(id));
        return "Collection with id number " + id + " is now deleted";

    }

    @RequestMapping(value = "/api/v1/candies/{candy_type}/{cost_per_unit}", method = RequestMethod.GET)
    public ResponseEntity<Candy> getCandiesByTypeAndCostPerUnit(@PathVariable String candy_type, @PathVariable int cost_per_unit) {
        var candy = candyRepository.getCandiesByType(candy_type, cost_per_unit);
        return new ResponseEntity<>(candy, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/v1/candies/weight_per_unit/{weight_per_unit}", method = RequestMethod.GET)
    public ResponseEntity<List<Candy>> getCandyByWeightPerUnit(@PathVariable int weight_per_unit) {
        var candy = candyRepository.findCandyByWeightPerUnitEquals(weight_per_unit);
        return new ResponseEntity<>(candy, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/v1/candies/candy_type/{candy_type}", method = RequestMethod.GET)
    public ResponseEntity<List<Candy>> getCandyByType(@PathVariable String candy_type) {
        var candy = candyRepository.findCandyByTypeEquals(candy_type);
        return new ResponseEntity<>(candy, HttpStatus.OK);
    }
}





package se.experis.jesper.microtask4.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Candy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "candy_name")
    private String name;

    @Column(name = "candy_type")
    private String type;

    @Column(name = "weight_per_unit")
    private int weightPerUnit;

    @Column(name = "cost_per_unit")
    private int costPerUnit;


    @ManyToMany(mappedBy = "candies")
    public List<Factory> factories;

    @JsonGetter("factories")
    public List<String> factoriesGetter() {
        if(factories != null){
            return factories.stream()
                    .map(factory -> {
                        return "/api/v1/factories/" + factory.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeightPerUnit() {
        return weightPerUnit;
    }

    public void setWeightPerUnit(int weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
    }

    public int getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(int costPerUnit) {
        this.costPerUnit = costPerUnit;
    }
}
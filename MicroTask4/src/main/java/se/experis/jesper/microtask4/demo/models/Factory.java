package se.experis.jesper.microtask4.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_factory")
    private String factoryName;

    @Column(name = "size_of_factory")
    private int size;


    @OneToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToMany
    @JoinTable(
            name = "candy_factory",
            joinColumns = {@JoinColumn(name = "factory_id")},
            inverseJoinColumns = {@JoinColumn(name = "candy_id")}
    )
    public List<Candy> candies;

    @JsonGetter("candies")
    public List<String> candies() {
        return candies.stream()
                .map(candy -> {
                    return "/api/v1/candies/" + candy.getId();
                }).collect(Collectors.toList());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
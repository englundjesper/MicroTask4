package se.experis.jesper.microtask4.demo.models;

import javax.persistence.*;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_manager")
    private String managerName;

    @Column(name = "date_of_birth")
    private String dob;

    @Column(name = "address_of_manager")
    private String address;


    @OneToOne(mappedBy = "manager")
    private Factory factory;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


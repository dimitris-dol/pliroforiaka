package com.example.Networks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import org.springframework.scheduling.annotation.Async;

@Entity // This tells Hibernate to make a table out of this class
public class Network {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "type must not be empty")
    private String type;

    @NotEmpty(message = "penetrationRate must not be empty")
    private String penetrationRate;

    @NotEmpty(message = "service must not be empty")
    private String service;

    @NotEmpty(message = "tech must not be empty")
    private String tech;

    @NotEmpty(message = "owner must not be empty")
    private String owner;

    @NotEmpty(message = "admin must not be empty")
    private String admin;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getPenetrationRate() {
        return penetrationRate;
    }

    public void setPenetrationRate(String penetrationRate) {
        this.penetrationRate = penetrationRate;
    }


    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }


    public String getTech() {
        return tech;
    }

    public void setTech(String tech) { this.tech = tech; }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }


}
package com.example.Networks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity // This tells Hibernate to make a table out of this class
public class Systems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must not be empty")
    private String name;

    @NotEmpty(message = "network must not be empty")
    private String network;

    @NotEmpty(message = "location must not be empty")
    private String location;

    @NotEmpty(message = "provider must not be empty")
    private String provider;

    @NotEmpty(message = "status must not be empty")
    private String status;

    @NotEmpty(message = "operatingDate must not be empty")
    private String operatingDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){ this.name = name; }


    public String getNetwork(){
        return network;
    }

    public void setNetwork(String network){
        this.network = network;
    }


    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }


    public String getProvider(){
        return provider;
    }

    public void setProvider(String provider){
        this.provider = provider;
    }


    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }


    public String getOperatingDate(){ return operatingDate; }

    public void setOperatingDate(String operatingDate){ this.operatingDate = operatingDate; }
}

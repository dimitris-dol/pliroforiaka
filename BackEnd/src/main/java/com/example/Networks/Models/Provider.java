package com.example.Networks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Provider {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	private String tin;

	private String service;

	private String area;

	private String type;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}


	public String getTin(){
		return tin;
	}

	public void setTin(String tin){
		this.tin = tin;
	}


	public String getService(){
		return service;
	}

	public void setService(String service){
		this.service = service;
	}


	public String getArea(){
		return area;
	}

	public void setArea(String area){
		this.area = area;
	}


	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}
}

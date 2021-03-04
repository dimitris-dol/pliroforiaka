package com.example.Networks;

import org.springframework.data.repository.CrudRepository;

import com.example.Networks.DataCenter;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DataCenterRepository extends CrudRepository<DataCenter, Integer> {

}

package com.example.Networks;

import org.springframework.data.repository.CrudRepository;

import com.example.Networks.Systems;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SystemsRepository extends CrudRepository<Systems, Integer> {

}

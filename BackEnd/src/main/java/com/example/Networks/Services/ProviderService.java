package com.example.Networks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProviderService {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ProviderRepository providerRepository;

    @Async
    public void print(String name, String tin, String service, String area, String type) {

            Provider n = new Provider();
            n.setName(name);
            n.setTin(tin);
            n.setService(service);
            n.setArea(area);
            n.setType(type);
            providerRepository.save(n);
            System.out.println("Saved");

    }

}
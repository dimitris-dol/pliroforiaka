package com.example.Networks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@Controller
@CrossOrigin
@RequestMapping(path="/systems") // This means URL's start with /demo (after Application path)
public class SystemsController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private SystemsRepository systemsRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewSystems (@Valid @RequestParam String name , @RequestParam String network, @RequestParam String location
            , @RequestParam String provider , @RequestParam String status , @RequestParam String operatingDate) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Systems n = new Systems();
        n.setName(name);
        n.setNetwork(network);
        n.setLocation(location);
        n.setProvider(provider);
        n.setStatus(status);
        n.setOperatingDate(operatingDate);
        systemsRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Systems> getAllSystems() {
        // This returns a JSON or XML with the users
        return systemsRepository.findAll();
    }
}

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

import com.example.Networks.CustomException;


@RestController
public class NetworkInputController {

    @Autowired
    NetworkService networkService;
    private NetworkRepository networkRepository;

    @RequestMapping(value = "/netinput")
    public String input() {
        String[] type = {"a","aa","a","a","a","","a","","a","a" };  // tha antikatastathei me json read
        String[] shortdesc = {"aasd","","asda","a","aa","ss","asdsd","","a","a" };
        String[] material = {"a","","a","a","a","","a","","a","a" };
        String[] tech = {"a","","abfghf","a1","a","","afff","","a","a" };
        String[] owner = {"a","","a","a","afghfgh","","af","","asssds","a" };
        String[] admin = {"a123","","afghhgf","a","a","","a","","a","a" };
            for(int i=0; i<10; i++) {
                networkService.print(type[i], shortdesc[i], material[i], tech[i], owner[i], admin[i]);
            }
        return "Jason file for Networks parsed to database";
    }
}
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
public class ProviderInputController {

    @Autowired
    ProviderService providerService;
    private ProviderRepository providerRepository;

    @RequestMapping(value = "/provinput")
    public String input() {
        String[] name = {"a","aa","a","a","a","","a","","a","a" };  // tha antikatastathei me json read
        String[] tin = {"aasd","","asda","a","aa","ss","asdsd","","a","a" };
        String[] service = {"a","","a","a","a","","a","","a","a" };
        String[] area = {"a","","abfghf","a1","a","","afff","","a","a" };
        String[] type = {"a","","a","a","afghfgh","","af","","asssds","a" };
        for(int i=0; i<10; i++) {
            providerService.print(name[i], tin[i], service[i], area[i], type[i]);
        }
        return "Jason file for Providers parsed to database";
    }
}
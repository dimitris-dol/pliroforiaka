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
public class DataCenterInputController {

    @Autowired
    DataCenterService dataCenterService;
    private DataCenterRepository dataCenterRepository;

    @RequestMapping(value = "/datacenterinput")
    public String input() {
        String[] name = {"a","aa","a","a","a","","a","","a","a" };  // tha antikatastathei me json read
        String[] shortdesc = {"aasd","","asda","a","aa","ss","asdsd","","a","a" };
        String[] location = {"a","","a","a","a","","a","","a","a" };
        String[] type = {"a","","abfghf","a1","a","","afff","","a","a" };
        String[] status = {"a","","a","a","afghfgh","","af","","asssds","a" };
        String[] operatingDate = {"a123","","afghhgf","a","a","","a","","a","a" };
        for(int i=0; i<10; i++) {
            dataCenterService.print(name[i], shortdesc[i], location[i], type[i], status[i], operatingDate[i]);
        }
        return "Jason file for Data Centers parsed to database";
    }
}
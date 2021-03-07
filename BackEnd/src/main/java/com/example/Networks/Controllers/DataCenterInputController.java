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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@RestController
public class DataCenterInputController {

    @Autowired
    DataCenterService dataCenterService;
    private DataCenterRepository dataCenterRepository;

    @RequestMapping(value = "/datacenterinput")
    public String input() {

        String fileName= "C:\\Users\\jimmd\\IdeaProjects\\Networks\\BackEnd\\src\\main\\java\\com\\example\\Networks\\Files\\datacenter.csv";
        File file= new File(fileName);

        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> name = lines.get(0);
        List<String> shortdesc = lines.get(1);
        List<String> location = lines.get(2);
        List<String> type = lines.get(3);
        List<String> status = lines.get(4);
        List<String> operatingDate = lines.get(5);
        for(int i=0; i<10; i++) {
            dataCenterService.print(name.get(i), shortdesc.get(i), location.get(i), type.get(i), status.get(i), operatingDate.get(i));
        }
        return "CSV file for Data Centers parsed to database";
    }
}
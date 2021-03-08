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
public class ProviderInputController {

    @Autowired
    ProviderService providerService;
    private ProviderRepository providerRepository;

    @RequestMapping(value = "/providerinput")
    public String input() {

        String fileName= "C:\\Users\\jimmd\\IdeaProjects\\Networks\\BackEnd\\src\\main\\java\\com\\example\\Networks\\Files\\providers.csv";
        File file= new File(fileName);

        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> name = lines.get(0);
        List<String> tin = lines.get(1);
        List<String> service = lines.get(2);
        List<String> area = lines.get(3);
        List<String> type = lines.get(4);
        for(int i=0; i<10; i++) {
            providerService.print(name.get(i), tin.get(i), service.get(i), area.get(i), type.get(i));
        }
        return "Jason file for Providers parsed to database";
    }
}
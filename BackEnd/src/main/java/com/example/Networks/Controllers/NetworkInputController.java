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
public class NetworkInputController {

    @Autowired
    NetworkService networkService;
    private NetworkRepository networkRepository;

    @RequestMapping(value = "/networkinput")
    public String input() {

        String fileName= "C:\\Users\\jimmd\\IdeaProjects\\Networks\\BackEnd\\src\\main\\java\\com\\example\\Networks\\Files\\networks.csv";
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

        List<String> type = lines.get(0);
        List<String> penetrationRate = lines.get(1);
        List<String> service = lines.get(2);
        List<String> tech = lines.get(3);
        List<String> owner = lines.get(4);
        List<String> admin = lines.get(5);
        for(int i=0; i<10; i++) {
            networkService.print(type.get(i), penetrationRate.get(i), service.get(i), tech.get(i), owner.get(i), admin.get(i));
        }
        return "Jason file for Networks parsed to database";
    }
}
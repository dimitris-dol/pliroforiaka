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

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
@RequestMapping(value = "/networkinput")
public class NetworkInputController {

    @Autowired
    NetworkService networkService;
    private NetworkRepository networkRepository;

    @GetMapping(value = "/csv")
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
        return "CSV file for Networks parsed to database";
    }

    @GetMapping(value = "/status")
    public String status(){

        String fileName= "C:\\Users\\jimmd\\IdeaProjects\\Networks\\BackEnd\\networks-error-log.txt";
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(fileName) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;

    }
}
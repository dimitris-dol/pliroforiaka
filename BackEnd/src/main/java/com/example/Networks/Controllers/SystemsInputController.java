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
public class SystemsInputController {

    @Autowired
    SystemsService systemsService;
    private SystemsRepository systemsRepository;

    @RequestMapping(value = "/systemsinput")
    public String input() {

        String fileName= "C:\\Users\\jimmd\\IdeaProjects\\Networks\\BackEnd\\src\\main\\java\\com\\example\\Networks\\Files\\systems.csv";
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
        List<String> network = lines.get(1);
        List<String> location = lines.get(2);
        List<String> provider = lines.get(3);
        List<String> status = lines.get(4);
        List<String> operatingDate = lines.get(5);
        for(int i=0; i<10; i++) {
            systemsService.print(name.get(i), network.get(i), location.get(i), provider.get(i), status.get(i), operatingDate.get(i));
        }
        return "CSV file for Systems parsed to database";
    }
}
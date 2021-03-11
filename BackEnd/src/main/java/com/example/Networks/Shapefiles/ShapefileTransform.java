package com.example.Networks;

import java.io.File;
import java.io.IOException;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapefileTransform {

    @RequestMapping(value = "/shapefile")
    public String command(){
        String output = "return.json";
        String input = "C:\\Users\\jimmd\\Desktop\\shp\\stations.shp";
        try {
            String com = "ogr2ogr -f \"GeoJSON\"" +" "+ output+ " " + input;
            System.out.println(com);
            String command = com;
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + command);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Json was created under the name 'return.json'";
    }

}

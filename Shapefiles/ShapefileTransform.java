package com.example.Networks;

import java.io.File;
import java.io.IOException;

public class ShapefileTransform {

    public static void shapefileTransform() {
        String[] cmd = {"-t_srs", "CRS:84", "-f", "GeoJSON","output.geojson","GRC_adm0.shp"};
        ogr2ogr.main(cmd);
    }
}

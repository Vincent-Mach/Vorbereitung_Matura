package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvConverter {

    public CsvConverter(){

    }

    public static List<Unterricht> readLessionsFromCSV(String fileName) throws IOException {
        List<Unterricht> unterrichtList = new ArrayList<>();
        Unterricht u;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // read the first line from the text file
            String line;
            br.readLine(); //headline überspringen
            line = br.readLine(); //erste Zeile Lesen
            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split("\t");

                u = new Unterricht(Integer.parseInt(attributes[4]),Integer.parseInt(attributes[5]),attributes[2],attributes[3]);

                // adding book into ArrayList
                unterrichtList.add(u);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }
            return unterrichtList;
        }
    }
}

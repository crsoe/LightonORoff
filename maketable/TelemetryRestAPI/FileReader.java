package org.example.maketable.TelemetryRestAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    String data;


    public FileReader() {
        try {
            File myObj = new File("C:\\Users\\chris\\Nackademin\\Systemintegration\\Console\\Console\\Phototransistor.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String datatxt = myReader.nextLine();
                this.data = datatxt;
                System.out.println("FileReader: " + data);
                //Thread.sleep(6000);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid data format in the file.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: Something went wrong.");
            e.printStackTrace();}
    }
        public String getData(){
            return data;
        }
}

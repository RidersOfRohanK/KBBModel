package util;

import model.Automobile;
import model.Option;
import model.OptionSet;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.*;

public class FileParser {

    public FileParser(){

    }
    public Automobile read(String filename){
        try {


            FileReader file = new FileReader("C:\\Users\\gamem\\IdeaProjects\\KBB\\src\\TestFiles\\"+filename);
            BufferedReader buff = new BufferedReader(file);
            String firstLine = buff.readLine();

            int indexOfSpace = firstLine.indexOf(" ");
            String make = firstLine.substring(0,indexOfSpace);//First line has model and make so need to split
            String model = firstLine.substring(indexOfSpace+1);

            double basePrice = Double.parseDouble(buff.readLine());//next line has base price

            Automobile newAuto = new Automobile(model,make,basePrice);
            boolean eof = false;

            while (!eof) {
                String line = buff.readLine();

                if (line == null) {eof = true;}
                else{

                    OptionSet newOptionSet = new OptionSet(line);
                    newAuto.addNewOptionSet(newOptionSet);
                    int numOptions = Integer.parseInt(buff.readLine());

                    for (int i = 0; i < numOptions; i++) {
                        line = buff.readLine();

                        int indexOfComma = line.indexOf(",");
                        String optionName = line.substring(0,indexOfComma);
                        double price = Double.parseDouble(line.substring(indexOfComma+1));
                        Option newOption = new Option(optionName,price);
                        newAuto.addNewOption(newOption,newOptionSet);
                    }

                }

            }buff.close();
            System.out.println("Auto Has been sucessfully created!");
            return newAuto;
        }catch(IOException e){
            System.out.println("Error ­­ " + e.toString());
        }
        System.out.println("The Automobile could not be created from the file, please try again");
        return null;
    }
}

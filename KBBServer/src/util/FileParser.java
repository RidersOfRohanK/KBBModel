package util;

import exception.AutoException;
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
        int errorno = 0;
        double basePrice = 0;

        try {

            errorno = 1;
            FileReader file = new FileReader("C:\\Users\\gamem\\IdeaProjects\\KBB\\src\\TestFiles\\"+filename);

            BufferedReader buff = new BufferedReader(file);
            String firstLine = buff.readLine();

            int indexOfSpace = firstLine.indexOf(" ");

            String make = firstLine.substring(0,indexOfSpace);//First line has model and make so need to split
            String model = firstLine.substring(indexOfSpace+1);

            errorno = 2;
            basePrice = Double.parseDouble(buff.readLine());//next line has base price

            Automobile newAuto = new Automobile(model,make,basePrice);
            boolean eof = false;

            while (!eof) {
                String line = buff.readLine();

                if (line == null) {eof = true;}
                else{
                    errorno = 3;
                    OptionSet newOptionSet = new OptionSet(line);
                    newAuto.addNewOptionSet(newOptionSet);
                    int numOptions = Integer.parseInt(buff.readLine());

                    for (int i = 0; i < numOptions; i++) {
                        errorno = 4;
                        line = buff.readLine();
                        int indexOfComma = line.indexOf(",");
                        errorno = 5;
                        String optionName = line.substring(0,indexOfComma);

                        double price = Double.parseDouble(line.substring(indexOfComma+1));
                        Option newOption = new Option(optionName,price);
                        newAuto.addNewOption(newOption,newOptionSet);
                    }

                }

            }buff.close();
            System.out.println("Auto Has been successfully created!");
            return newAuto;
        }catch(IOException e){
            System.out.println("Error ­­ " + e.toString());
            AutoException ae = new AutoException();
            ae.addException(e);
            if(errorno == 1){
                String newFileName = (String )ae.fixAuto(1);
                filename = newFileName;
            }
            else if(errorno ==2 ){
                Double Price = (Double)ae.fixAuto(2);
                basePrice = Price;
            }
            else if(errorno == 3){
                String optionSetName = (String)ae.fixAuto(3);

            }
            else if(errorno == 4){
                int numOptions = (int)(ae.fixAuto(4));

            }
            else if(errorno == 5){
                String OptionString  = (String ) ae.fixAuto(5);
                int indexOfComma = OptionString.indexOf(",");
                errorno = 5;
                String optionName = OptionString.substring(0,indexOfComma);

                double price = Double.parseDouble(OptionString.substring(indexOfComma+1));
                Option newOption = new Option(optionName,price);

            }


        }
        System.out.println("The Automobile could not be created from the file, please try again");
        return null;
    }
}

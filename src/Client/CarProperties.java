package Client;

import jdk.javadoc.doclet.Doclet;
import model.Automobile;
import model.Option;
import model.OptionSet;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class CarProperties {
    String model;
    String make;
    ArrayList<OptionSet> optionSets;

    public CarProperties() {
        optionSets = new ArrayList<>();
    }

    public Object load(String filename) {
//        src/TestFiles/PropertiesTest.prop
        try {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            int indexOfSign = line.indexOf("=");
            model = line.substring(indexOfSign+1);
            line = reader.readLine();
            indexOfSign = line.indexOf("=");
            make = line.substring(indexOfSign+1);
            line = reader.readLine();
            double price = Double.parseDouble(line);

            Automobile a = new Automobile(model,make,price);

            line = reader.readLine();
            while (line != null && !line.isEmpty()) {
                System.out.println(line);
                if(!line.contains("Value")){
                    indexOfSign = line.indexOf("=");
                    OptionSet op = new OptionSet(line.substring(indexOfSign+1));
                    optionSets.add(op);
                    a.addNewOptionSet(op);

                }
                else{
                    int indexOfComma = line.indexOf(",");
                    String optionName = line.substring(0,indexOfComma);
                    Double optionPrice = Double.parseDouble(line.substring(indexOfComma+1));
                    OptionSet currentOptionSet = optionSets.get(optionSets.size()-1);
                    currentOptionSet.addOption(new Option(optionName,optionPrice));
                }
                // parse this.color=blah

                line = reader.readLine();
            }
            return a;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("(Props) Error in file directory ... ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("(Props) Error reading file from directory ... ");
            System.exit(1);
        }
        return null;
    }
}

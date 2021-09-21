package Client;

import jdk.javadoc.doclet.Doclet;
import model.Automobile;
import model.Option;
import model.OptionSet;

import java.io.*;
import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.Properties;

public class CarProperties {
    String model;
    String make;
    ArrayList<OptionSet> optionSets;
    ArrayList<String> setNames;

    public CarProperties() {
        optionSets = new ArrayList<>();
        setNames = new ArrayList<>();
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

                if(!line.contains("Value")){
                    indexOfSign = line.indexOf("=");
                    String nameOfSet = line.substring(indexOfSign+1);
                    setNames.add(nameOfSet);

                    OptionSet op = new OptionSet(nameOfSet);
                    optionSets.add(op);
                    a.addNewOptionSet(op);

                }
                else{
                    int indexOfComma = line.indexOf(",");
                    int indexOfEqual = line.indexOf("=");
                    String optionName = line.substring(indexOfEqual+1,indexOfComma);
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

    public String getOptionSetNames(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < setNames.size(); i++) {
             sb.append(setNames.get(i));
             sb.append(",");

        }
        return sb.toString();

    }


    public String getOptionNames(String resp) {
        int indexOfSet = findIndexOfSet(resp);
        OptionSet op = optionSets.get(indexOfSet);
        return op.toString();
    }
    private int findIndexOfSet(String resp){

        for (int i = 0; i < setNames.size(); i++) {
            String setName = setNames.get(i);
            if(setName.equals(resp)){
                return i;
            }

        }
        return -1;
    }

    public Object create(String StringOfProperties) {

            String [] optionSets = StringOfProperties.split("]");

            String priceString = optionSets[optionSets.length-1];
            Double price = Double.parseDouble(priceString);

            Automobile a = new Automobile(model,make,price);
        for (int i = 0; i < optionSets.length-1; i++) {
            String optionSet = optionSets[i];
            int indexOfComma = optionSet.indexOf(",");
            String optionSetName = optionSet.substring(1,indexOfComma);
            OptionSet op = new OptionSet(optionSetName);
            String options = optionSet.substring(indexOfComma+1);
            String [] Options = options.split("}");
            for (int j = 0; j < Options.length; j++) {
                String option = Options[j];

                int indexOfCommaOption = option.indexOf(",");
                if(indexOfCommaOption <= 2){
                    indexOfCommaOption = option.indexOf(indexOfCommaOption+1);
                }
                String optionName = option.substring(1,indexOfCommaOption);
                Double Price = Double.parseDouble(option.substring(indexOfCommaOption+1));

                Option o = new Option(optionName,Price );
                op.addOption(o);

            }
            a.addNewOptionSet(op);

        }
        return a;
    }
}

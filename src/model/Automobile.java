package model;

import util.Serializer;

import java.io.Serializable;
import java.util.ArrayList;

public class Automobile implements Serializable {
    private double basePrice;
    private ArrayList<OptionSet> optionSets;
    private ArrayList<Option> choices;
    private String make;
    private String modelName;

    public Automobile(String modelName, String make, double basePrice) {

        optionSets = new ArrayList<>();
        this.basePrice = basePrice;
        choices = new ArrayList<>();
        this.modelName = modelName;
        this.make = make;

    }

    public String getName() {

        return getMake()+ " " + getModelName() ;
    }

    public void addNewOptionSet(OptionSet o) {
        optionSets.add(o);
    }

    public void addNewOption(Option o, String optionSetName) {
        OptionSet op = getOptionSet(optionSetName);
        op.addOption(o);
    }

    public void addNewOption(Option o, OptionSet op) {
        op.addOption(o);
    }

    public ArrayList<Option> getChoices() {
        return choices;
    }

    public String getMake() {
        return make;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getBasePrice() {
        return basePrice;
    }


    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getTotalPriceofChoices() {
        int totalPrice = 0;
        for (int i = 0; i < choices.size(); i++) {
            Option o = choices.get(i);
            totalPrice += o.getPrice();
        }
        totalPrice += basePrice;
        return totalPrice;
    }

    public OptionSet getOptionSet(String name) {
        for (int i = 0; i < optionSets.size(); i++) {
            OptionSet optionSet = optionSets.get(i);
            if (optionSet.getName().equals(name)) {
                return optionSet;
            }
        }
        System.out.println("Option set with that name does not exist. Try again!");
        return null;
    }

    public OptionSet getOptionSet(int index) {
        return optionSets.get(index);
    }

    public void setNewOptionSet(OptionSet o, int index) {
        optionSets.add(o);//sets optionset at an index to a preexisting optionset
    }

    public void setNewOptionSet(OptionSet o, String name) {
        for (int i = 0; i < optionSets.size(); i++) {
            OptionSet optionSet = optionSets.get(i);
            if (optionSet.getName().equals(name)) {
                OptionSet optionSet1 = optionSets.get(i);
                optionSet1 = o;
            }

        }
        System.out.println("No such optionset with that name");
    }

    public void updateOptionSetName(String optionSetName, String newName) {
        OptionSet optionSet = getOptionSet(optionSetName);
        optionSet.setName(newName);
    }

    public void deleteOptionSet(int index) {
        optionSets.remove(index);
    }

    //Once again overloaded for index and name
    public void deleteOptionSet(String name) {

        for (int i = 0; i < optionSets.size(); i++) {
            if (name.equals(optionSets.get(i).getName())) {//goes through all optionsets and if they have the same name then it skips that one
                optionSets.remove(i);
            }

        }
    }

    public String getOptionChoiceString(String setName) {
        OptionSet op = getOptionSet(setName);
        Option choice = op.getOptionChoice();
        return choice.getName();
    }

    public double getOptionChoicePrice(String setName) {
        OptionSet op = getOptionSet(setName);
        Option choice = op.getOptionChoice();
        return choice.getPrice();
    }

    public Option getOptionChoice(String setName) {
        OptionSet optionSet = getOptionSet(setName);
        return optionSet.getOptionChoice();
    }

    public void updateOptionName(int indexOfOptionSet, String nameOfOption, String newName) {
        OptionSet o = optionSets.get(indexOfOptionSet);
        o.updatedOptionName(nameOfOption, newName);
    }

    public void setOptionChoice(String setName, String optionName) {
        OptionSet op = getOptionSet(setName);
        op.setOptionChoice(optionName);
    }

    public void updateOptionName(String optionSetName, String oldOptionName, String newName) {
        OptionSet o = getOptionSet(optionSetName);
        Option toChange = o.getOption(oldOptionName);
        toChange.setName(newName);
    }


    public void updateOptionPrice(int indexOfOptionSet, String nameOfOption, double newPrice) {
        OptionSet o = optionSets.get(indexOfOptionSet);
        o.updateOptionPrice(nameOfOption, newPrice);

    }

    public void updateOptionPrice(String optionSetName, String OptionName, double newPrice) {
        OptionSet o = getOptionSet(optionSetName);
        Option toChange = o.getOption(OptionName);
        toChange.setPrice(newPrice);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < optionSets.size(); i++) {//goes through all optionSets and uses their method
            OptionSet optionSet = optionSets.get(i);
            s.append(optionSet.toString());

        }
        s.append(basePrice);//then adds price and name
        return s.toString();//then converts to a String
    }

    public int findIndexOfOptionSet(String optionName) {//helper for proxy Auto

        for (int i = 0; i < optionSets.size(); i++) {
            OptionSet optionSet = optionSets.get(i);
            if (optionSet.findOptionIndex(optionName) != -1) {
                return i;
            }
        }

        return -1;
    }
}




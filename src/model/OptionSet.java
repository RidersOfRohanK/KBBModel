package model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable {
    private ArrayList<Option> options;
    private String name;
    private Option choice = null;


    public OptionSet(String name) {
        this.name = name;
        options = new ArrayList<Option>();
    }
    public OptionSet() {
            name = "";
        options = new ArrayList<Option>();
    }

    public void addOption(Option o){
        options.add(o);
    }//check

    protected void setName(String name) {
        this.name = name;
    }

    protected void addNewOptionSet(Option o) {
        options.add(o);
    }

    protected String getName() {
        return name;
    }

    protected ArrayList<Option> getFullOptionSet() {
        return options;
    }//support method

    protected Option getOption(int index) {
        return options.get(index);
    }

    protected Option getOption(String name) {
        for (int i = 0; i < options.size(); i++) {
            Option option = options.get(i);
            if (option.getName().equals(name)) {
                return option;
            }

        }
        System.out.println("No such option found. Check spelling or double check if option exists");
        return null;
    }

    protected void updateOptionPrice(String nameOfOption, double newPrice) {//find and update price using name
        Option o = getOption(nameOfOption);
        o.setPrice(newPrice);
    }

    protected void updateOptionPrice(int indexOfOption, double newPrice) {//Overloaded other method to find using index as well
        Option o = getOption(indexOfOption);
        o.setPrice(newPrice);
    }

    protected void updatedOptionName(String nameOfOption, String newName) {//find and update name using the old name
        Option o = getOption(nameOfOption);
        o.setName(newName);
    }

    protected void updateOptionName(int index, String newName) {//overloaded other method to find using index as well
        Option o = getOption(index);
        o.setName(newName);
    }

    public String toString() {//wouldn't let me make this protected for some reason
        StringBuffer s = new StringBuffer();
        s.append("[");
        s.append(name);//then adds name
        for (int i = 0; i < options.size(); i++) {//Goes through all options and uses their toString method
            Option option = options.get(i);
            s.append(",");
            s.append(option.toString());

        }
        s.append("]");
        return s.toString();
    }

    protected int findOptionIndex(String name) {
        for (int i = 0; i < options.size(); i++) {
            Option option = options.get(i);
            if (option.getName().equals(name)) {
                return i;
            }

        }
        return -1;
    }

    protected int getTotalPrice(){//goes through all the options and summates the price
        int totalPrice = 0;
        for (int i = 0; i < options.size(); i++) {
            totalPrice+=options.get(i).getPrice();

        }
        return totalPrice;
    }

    protected Option getOptionChoice(){
        return choice;
    }


    protected void setOptionChoice(String optionName){
        for (int i = 0; i < options.size(); i++) {
            if(options.get(i).getName().equals(optionName)){
                choice = options.get(i);
            }

        }
    }

    protected double getOptionChoicePrice(){
        return choice.getPrice();
    }

}

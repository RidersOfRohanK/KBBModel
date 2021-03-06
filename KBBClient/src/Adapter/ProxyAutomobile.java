package Adapter;

import exception.AutoException;
import model.AutoTemplate;
import model.Automobile;
import util.FileParser;


public abstract class ProxyAutomobile {
    private static AutoTemplate<Automobile> automobileLinkedHashMap = new AutoTemplate<>();

    public Automobile buildAuto(String filename) {
        FileParser fp = new FileParser();
        Automobile a = fp.read(filename);
        return a;
    }

    public void printAuto(String name) {

        automobileLinkedHashMap.printAuto(name);

    }


    public void updateOptionSetName(String modelName, String optionSetName, String newName) {//model name present for when we add in hashing

        Automobile a = automobileLinkedHashMap.getAuto(modelName);
        a.updateOptionSetName(optionSetName, newName);
    }

    public void updateOptionPrice(String modelName, String optionSetName, String optionName, double price) { //model name present for when we add in hashing

        //use automobile methods but allows the automobile ot be hidden
        Automobile a = automobileLinkedHashMap.getAuto(modelName);
        a.updateOptionPrice(optionSetName, optionName, price);

    }

    public void removeAuto(String name) {
        automobileLinkedHashMap.removeAuto(name);
    }

    public void removeAuto(Automobile a){
        automobileLinkedHashMap.removeAuto(a);
    }

    public void addAuto(Automobile auto) {
        automobileLinkedHashMap.addAuto(auto);


    }

    public Automobile getAuto(String name){
        return automobileLinkedHashMap.getAuto(name);
    }

    public Object fixAuto(int errorno){
        AutoException autoException = new AutoException();
       return autoException.fixAuto(errorno);
    }
}

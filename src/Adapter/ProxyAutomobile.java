package Adapter;

import model.Automobile;
import util.FileParser;
import util.Serializer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public abstract class ProxyAutomobile{
    private LinkedHashMap<String,Automobile> automobileLinkedHashMap = new LinkedHashMap<>();

    public Automobile buildAuto(String filename){
        FileParser fp = new FileParser();
        Automobile a = fp.read(filename);
//        automobile = fp.read(filename);
        return a;
    }

    public void printAuto(String name){
//        System.out.println(automobile.toString());

        Automobile a = automobileLinkedHashMap.get(name);

        System.out.println(a.toString());



    }


    public void updateOptionSetName(String modelName,String optionSetName,String newName){//model name present for when we add in hashing
//         automobile.updateOptionSetName(optionSetName,newName);
            Automobile a = automobileLinkedHashMap.get(modelName);
            a.updateOptionSetName(optionSetName,newName);
    }
    public void updateOptionPrice(String modelName,String optionSetName,String optionName,double price){ //model name present for when we add in hashing
//        automobile.updateOptionPrice(optionSetName,optionName,price);
        //use automobile methods but allows the automobile ot be hidden
        Automobile a = automobileLinkedHashMap.get(modelName);
        a.updateOptionPrice(optionSetName,optionName,price);

    }
    public void removeAuto(String name){
        automobileLinkedHashMap.remove(name);
    }
    public void addAuto(Automobile auto){
        automobileLinkedHashMap.put(auto.getName(),auto);


        }
}

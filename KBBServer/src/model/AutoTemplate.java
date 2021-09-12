package model;

import java.util.LinkedHashMap;

public class AutoTemplate <T extends Automobile> {

    private LinkedHashMap<String,Automobile> automobileLinkedHashMap = new LinkedHashMap<>();

    public void addAuto(Automobile auto){
        automobileLinkedHashMap.put(auto.getName(),auto);
    }

    public void removeAuto(String name){
        automobileLinkedHashMap.remove(name);
    }

    public void removeAuto(Automobile a){
        automobileLinkedHashMap.remove(a.getName());
    }

    public LinkedHashMap<String,Automobile> returnLinkedHashMap(){

        return automobileLinkedHashMap;

    }

    public Automobile getAuto(String name){
        return automobileLinkedHashMap.get(name);
    }
    public void printAllAutos(){
        for (int i = 0; i< automobileLinkedHashMap.size();i++){
            System.out.println(automobileLinkedHashMap.get(i).toString());
        }
    }
    public void printAuto(String name){
        System.out.println(automobileLinkedHashMap.get(name).toString());
    }

}

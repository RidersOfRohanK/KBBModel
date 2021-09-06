package scale;

import Adapter.BuildAuto;
import model.Automobile;

public class EditOptions extends Thread{
    BuildAuto automobiles = new BuildAuto();
    public EditOptions(){

    }
    public void addAutomobile(Automobile a) {
        synchronized (this) {
            automobiles.addAuto(a);
        }
    }

    public void removeAuto(String name){
        synchronized (this){
            automobiles.removeAuto(name);
        }
    }

    public void removeAuto(Automobile a){
        synchronized (this){
            automobiles.removeAuto(a);
        }
    }

    public void updateOptionPrice(String modelName, String optionName, String Option, double newPrice) {
        synchronized (this) {
            //needs to serach through models and then find the correct option and then update that part of it
            automobiles.updateOptionPrice(modelName, optionName, Option, newPrice);
        }


    }

    public void updateOptionSetName(String modelName, String optionSetName, String newName) {
        //needs to serach through models and then find the correct option and then update that part of it
        synchronized (this) {

            automobiles.updateOptionSetName(modelName,optionSetName,newName);
        }
    }


}

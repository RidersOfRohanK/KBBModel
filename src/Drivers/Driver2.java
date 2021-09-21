package Drivers;

import Adapter.BuildAuto;
import Adapter.CreateAuto;
import model.Automobile;

public class Driver2 {
    public static void main(String[] args) {
        BuildAuto auto = new BuildAuto();


        Automobile a = auto.buildAuto("Ford Focus Wagon ZTW");//exception handling in this part of code

        auto.addAuto(a);

        auto.updateOptionPrice("Ford Focus Wagon ZTW","Color","Fort Knox Gold",40);
        auto.updateOptionSetName("Ford Focus Wagon ZTW","Transmission","Zoom Zoom");


        auto.printAuto("Ford Focus Wagon ZTW");



    }
}

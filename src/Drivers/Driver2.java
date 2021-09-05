package Drivers;

import Adapter.BuildAuto;
import Adapter.CreateAuto;
import model.Automobile;

public class Driver2 {
    public static void main(String[] args) {
        BuildAuto auto = new BuildAuto();


        auto.buildAuto("test");

        auto.updateOptionPrice("Ford Wagon ZTW","Color","Fort Knox Gold",40);
        auto.updateOptionSetName("Ford Wagon ZTW","Transmission","Zoom Zoom");

        auto.printAuto("Ford Wagon ZTW");



    }
}

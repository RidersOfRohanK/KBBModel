package Drivers;

import Adapter.BuildAuto;
import model.Automobile;
import util.FileParser;

public class Driver3 {
    public static void main(String[] args) {
        BuildAuto buildAuto = new BuildAuto();


        Automobile a  = buildAuto.buildAuto("Ford Focus Wagon ZTW");

        buildAuto.addAuto(a);

        buildAuto.printAuto("Ford Focus Wagon ZTW");

        buildAuto.updateOptionPrice("Ford Focus Wagon ZTW","Color","Fort Knox Gold",40);
        buildAuto.updateOptionSetName("Ford Focus Wagon ZTW","Transmission","Zoom Zoom");

        buildAuto.printAuto("Ford Focus Wagon ZTW");

        buildAuto.removeAuto("Ford Focus Wagon ZTW");

    }
}

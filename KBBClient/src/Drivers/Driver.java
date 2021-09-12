package Drivers;

import model.Automobile;
import util.FileParser;
import util.Serializer;

public class Driver {
    public static void main(String[] args) {
        FileParser p = new FileParser();
        Automobile a  = p.read("Ford Focus Wagon ZTW");



        System.out.println(a.getBasePrice());
        System.out.println(a.getMake());
        System.out.println(a.getModelName());

        Serializer s = new Serializer();
        s.serialize(a,"Ford ZTW");
        s.deserialize("Ford ZTW");
    }
}

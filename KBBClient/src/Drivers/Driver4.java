package Drivers;

import model.Automobile;
import scale.EditOptions;

public class Driver4 {
    public static void main(String[] args) {
        //creating threads
        EditOptions e1 = new EditOptions();
        EditOptions e2 = new EditOptions();

        //threads
        e1.start();
        e2.start();

        Boolean e1IsAlive = true;
        Boolean e2IsAlive = true;

        //building Auto through deserialization
        Automobile Ford =  e1.buildAuto("Ford Focus Wagon ZTW");

        Automobile Tesla = e2.buildAuto("Tesla Model 3");

        //Adding both Automobiles to the linked hash map
        //adding them to the same linked hashmap but dividing the work between the 2 threads
        e1.addAutomobile(Ford);

        e2.addAutomobile(Tesla);

        //using the two threads to edit the object's prices and show that the threads are synchronized and don't conflict or cause the data to become corrupted
        e1.updateOptionPrice("Ford Focus Wagon ZTW", "Color", "Fort Knox Gold", 100);
        e1.updateOptionPrice("Tesla Model 3","Color","Blue",200);
        e2.updateOptionPrice("Tesla Model 3","Color","Blue",75);
        /*
          Using the same thread to print a value from two different objects to prove the Linked Hash Map is static and
          that both threads are operating using the same Linked Hash Map, and that the threads are synchronized.
        */
        System.out.println(e1.getAuto("Tesla Model 3").getOptionPrice("Color","Blue"));
        System.out.println(e1.getAuto("Ford Focus Wagon ZTW").getOptionPrice("Color","Fort Knox Gold"));

        //Checking if the threads are done and terminated.
        do {
            if(e1IsAlive && !e1.isAlive()) {
                e1IsAlive = false;
                System.out.println("e1 is dead.");
            }
            if(e2IsAlive && !e2.isAlive()) {
                e2IsAlive = false;
                System.out.println("e2 is dead.");
            }
        } while(e1IsAlive || e2IsAlive);
    }
}


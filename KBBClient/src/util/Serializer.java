package util;

import model.Automobile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    public Serializer(){

    }

    public void serialize(Automobile automobile, String filename){ //takes the automobile and writes it into a file name of your choosing
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename+".dat"));

            out.writeObject(automobile);
            out.close();
        }catch(Exception e)
        { System.out.print("Error: " + e);
            System.exit(1);
        }

    }

    public Automobile deserialize(String filename){//takes the a file and makes an automobile based off that file
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename + ".dat"));
            return (Automobile) in.readObject();
        }catch(Exception e)
        { System.out.print("Error: " + e);
            System.exit(1);
        }
        return null;

    }


}

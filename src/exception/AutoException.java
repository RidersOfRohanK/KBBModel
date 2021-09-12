package exception;

import Adapter.fixAuto;
import model.Automobile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AutoException extends Exception implements fixAuto {
    Exception e;
    public AutoException(){

    }

    public void fixAuto(int errorNum){
        switch (errorNum){
            case 1://missing name
                fixReaderExceptions fixit1 = new fixReaderExceptions(errorNum);
                fixit1.addExeption(e);

            case 2://missing price
                //add

            case 3://missing optionSet name
                //add

            case 4://missing optionSet amount of Options
                //add

            case 5://missing option - -1 to 0 index for substring
                //add
                break;

        }
    }

    public void addException(Exception e){
        this.e = e;
    }

    public void addToLog(String errorMessage){//prints and creates a running log
        try {
            StringBuffer s = new StringBuffer();
            s.append(errorMessage);
            s.append(java.time.LocalTime.now());
            s.append("\n");

            BufferedWriter writer = new BufferedWriter(new FileWriter("errorLog"));
            writer.append(s.toString());
            writer.close();
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

}

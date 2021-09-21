package exception;

import Adapter.fixAuto;
import model.Automobile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AutoException extends Exception implements fixAuto {
    Exception e;

    public AutoException() {

    }

    public Object fixAuto(int errorNum) {
        switch (errorNum) {
            case 1://missing name
                fixReaderExceptions fixit1 = new fixReaderExceptions(errorNum);
                fixit1.addExeption(e);
                return fixit1.fixAuto();

            case 2://missing price
                fixReaderExceptions fixit2 = new fixReaderExceptions(errorNum);
                fixit2.addExeption(e);
                return fixit2.fixAuto();

            case 3://missing optionSet name
                fixReaderExceptions fixit3 = new fixReaderExceptions(errorNum);
                fixit3.addExeption(e);
                return fixit3.fixAuto();

            case 4://missing optionSet amount of Options
                fixReaderExceptions fixit4 = new fixReaderExceptions(errorNum);
                fixit4.addExeption(e);
                return fixit4.fixAuto();

            case 5://missing option - -1 to 0 index for substring
                fixReaderExceptions fixit5 = new fixReaderExceptions(errorNum);
                fixit5.addExeption(e);
                return fixit5.fixAuto();

        }
        System.out.println("no solution for current problem");
        return null;
    }

    public void addException(Exception e) {
        this.e = e;
    }

    public void addToLog(String errorMessage) {//prints and creates a running log
        try {
            StringBuffer s = new StringBuffer();
            s.append(errorMessage);
            s.append(java.time.LocalTime.now());
            s.append("\n");

            BufferedWriter writer = new BufferedWriter(new FileWriter("errorLog"));
            writer.append(s.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

}

package exception;

import model.Automobile;

public class AutoException extends Exception {

    public AutoException(){

    }

    public void fix(int errorNum){
        switch (errorNum){
            case 1://missing name
                fixReaderExceptions fixit1 = new fixReaderExceptions(errorNum);
                break;
            case 2://missing price
                //add
                break;
            case 3://missing optionSet name
                //add
                break;
            case 4://missing optionSet amount of Options
                //add
                break;
            case 5://missing option - -1 to 0 index for substring
                //add
                break;

        }
    }

    public void addToLog(String errorMessage){//prints and creates a running log
        StringBuffer s = new StringBuffer();
        System.out.println(errorMessage+java.time.LocalTime.now());

    }

}

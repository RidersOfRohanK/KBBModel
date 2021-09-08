package exception;

import Adapter.fixAuto;

public class fixReaderExceptions extends Exception implements fixAuto {//check if it implements fixAuto
    int errorno;
    public fixReaderExceptions(int errorno){
        this.errorno = errorno;
    }

    public void fixAuto(int errorno) {

    }
}

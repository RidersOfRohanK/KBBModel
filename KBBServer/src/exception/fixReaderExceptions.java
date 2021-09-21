package exception;

import Adapter.BuildAuto;
import Adapter.fixAuto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fixReaderExceptions {
    int errorno;
    Exception e;
    public fixReaderExceptions(int errorno){
        this.errorno = errorno;
    }

    public Object fixAuto() {
        switch (errorno){
            case 1:
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//has the user input it on the spot thus fixing the problem right there
                    System.out.println("Put in the new Name: ");
                    return reader.readLine();

                } catch (IOException e){
                    System.out.println(e);
                    return "";
                }
            case 2:
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//has the user input it on the spot thus fixing the problem right there
                    System.out.println("Put in the new Price: ");
                    return Double.parseDouble(reader.readLine());

                } catch (IOException e){
                    System.out.println(e);
                    return 0;
                }
            case 3:
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//has the user input it on the spot thus fixing the problem right there
                    System.out.println("Put in the new OptionSet Name: ");
                    return reader.readLine();

                } catch (IOException e){
                    System.out.println(e);
                    return "";
                }
            case 4:
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//has the user input it on the spot thus fixing the problem right there
                    System.out.println("Put in the number of Options: ");
                    return Integer.parseInt(reader.readLine());

                } catch (IOException e){
                    System.out.println(e);
                    return 0;
                }
            case 5:
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//has the user input it on the spot thus fixing the problem right there
                    System.out.println("Put in the missing option in this format OptionName,Price: ");
                    return reader.readLine();

                } catch (IOException e){
                    System.out.println(e);
                    return ",0";
                }
        }
        System.out.println("no fix could be found");
        return null;
    }

    public void addExeption(Exception e) {
        this.e = e;
    }
}

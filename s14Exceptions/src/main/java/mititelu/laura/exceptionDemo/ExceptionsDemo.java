package mititelu.laura.exceptionDemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;

public class ExceptionsDemo {

    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("\nInside main ...");
        try{
            share();
            System.out.println("After invoking share ...");
        }catch (FileNotFoundException e){
            //e.printStackTrace();
            System.out.println("main: FileNotFoundException ...");
        } finally {
            System.out.println("Inside main's finally ...");
        }
        System.out.println("\nEnd of main ...");
    }

    private static void share() throws FileNotFoundException{
        System.out.println("\nInside share ...");

        try {
            HttpConnect.send(0, "Hello", "https://www.goodsnips.com");
            System.out.println("After invoking send");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Share: FileNotFoundException ...");
            throw e;
        } catch (IOException e) {
            System.out.println("Connecting to a different server ...");
        }finally {
            System.out.println("Inside share's finally ...");
        }

        System.out.println("\nEnd of share ...");
    }

}

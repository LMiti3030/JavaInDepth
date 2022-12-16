package mititelu.laura.exceptionDemo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpConnect {

    //must document unchecked exception sent
    public static void send(int destination, String data, String partner) throws IOException {
        System.out.println("\nInside send ...");

        //check precondition
        if( destination < 0 || destination > 1){
            throw new IllegalArgumentException("Destination must be 0 or 1");
        }


        //destination will tell us how data will be transmitted
        //0-file on the local server hdd + script that pushes the file to the partner
        //1- push data directly to the partner site through a webservice

        if(destination == 0){
            //exception if file is missing
            throw new FileNotFoundException();
        } else if (destination == 1){
            throw new IOException();
        }

        System.out.println("\nEnd of send ...");
    }
}

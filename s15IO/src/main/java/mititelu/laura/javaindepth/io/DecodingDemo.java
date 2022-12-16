package mititelu.laura.javaindepth.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class DecodingDemo {

    public static void main(String[] args) {
        encodingSync();
    }

    public static void encodingSync(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("encoding.txt"),"UTF-8"))){
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            System.out.println(new String("€".getBytes(StandardCharsets.UTF_8), "UTF-8"));
            System.out.println(new String("a".getBytes(StandardCharsets.US_ASCII), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}

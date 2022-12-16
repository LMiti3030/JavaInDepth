package mititelu.laura.javaindepth.io;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class IODemo {

    static String inFileStr = "walden.jpg";
    static String outFileStr = "walden-out.jpg";

    public static void main(String[] args) {
        //fileCopyNoBuffer();
        //fileCopyWithBufferAndArray();
//        fileMethodsDemo();
//        dirFilter(true);

    }

    //read from one file an
    public static void fileCopyNoBuffer(){
        System.out.println("\nInside fileCopyNoBuffer");

        long startTime, elapsedTime; //for speed benchmarking

        //Print file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");

        try(FileInputStream in = new FileInputStream(inFileStr);
            FileOutputStream out = new FileOutputStream(outFileStr)){
            startTime = System.nanoTime();
            int byteRead;
            //read a raw byte, returns an int of 0 to 255
            while((byteRead = in.read()) != -1){
                //write the least significant byte of int , drop the upper 3 bytes
                out.write(byteRead);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
        }  catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void fileCopyWithBufferAndArray(){
        System.out.println("\nInside fileCopyWithBufferAndArray");

        long startTime, elapsedTime; //for speed benchmarking

        //Print file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");

        startTime = System.nanoTime();
        try(BufferedInputStream in = new BufferedInputStream( new FileInputStream(inFileStr));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))){
            byte[] byteBuf = new byte[4000];
            int numBytesRead;
            //read a raw byte, returns an int of 0 to 255
            while((numBytesRead = in.read(byteBuf)) != -1){
                //write the least significant byte of int , drop the upper 3 bytes
                out.write(byteBuf, 0, numBytesRead);
            }

        }  catch (IOException e){
            e.printStackTrace();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
    }

    public static void fileMethodsDemo(){
        System.out.println("\nInside fileMethodsDemo...");

        File f = new File("D:\\Programare\\Udemy Thales\\JavaInDepth\\s15IO\\src\\..\\walden.jpg"); // src\..\ -> will use the parent of src

        System.out.println("getAbsolutePath(): " + f.getAbsolutePath());
        try{
            System.out.println("getCanonicalPath(): " + f.getCanonicalPath());
            System.out.println("createNewFile(): " + f.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("separator: " + File.separator);
        System.out.println("separatorChar: " + File.separatorChar);
        System.out.println("getParent(): " + f.getParent()); //returns parent directory structure - uses absolute path from pathname (including src\..\)
        System.out.println("lastModified(): " + f.lastModified()); //returns time in miliseconds from epoch time = 1970
        System.out.println("exists(): " + f.exists());
        System.out.println("isFile(): " + f.isFile());
        System.out.println("isDirectory(): " + f.isDirectory());
        System.out.println("length(): " + f.length()); //size of the file
        System.out.println("exists(): " + f.exists());

        System.out.println("My working or user directory using System.getProperty(\"user.dir\") is: " + System.getProperty("user.dir"));
        System.out.println("new File(\"testdir\").mkdir(): " + new File("testdir").mkdir());
        System.out.println("new File(\"testdir\\test\").mkdir(): " + new File("testdir\\test").mkdir());
        System.out.println( "new File(\"testdir\").delete(): " + new File("testdir").delete());
        System.out.println("new File(\"testdir\\test1\\test2\").mkdir()" + new File("testdir\\test1\\test2").mkdir()); //returns false- need to use mkdirs to create multiple dirs
        System.out.println("new File(\"testdir\\test1\\test2\").mkdirs()" + new File("testdir\\test1\\test2").mkdirs());

        try{
            File f2  = new File("temp.txt");
            System.out.println("f2.createNewFile(): " + f2.createNewFile());
            System.out.println("f2.renameTo(new File(\"testdir\\\\temp1.txt\")): " + f2.renameTo(new File("testdir\\temp1.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void dirFilter(boolean applyFilter){
        System.out.println("\nInside dirFilter...");

        File path = new File("."); //references the current working directory
        String[] list;
        if(!applyFilter){
            list = path.list(); // all names of directories and files in the path
        } else{
            //list = path.list(new DirFilter());
//            FilenameFilter filter = new FilenameFilter() {
//                @Override
//                public boolean accept(File dir, String name) {
//                    return name.endsWith(".jpg") || name.endsWith(".JPG");
//                }
//            };
//            list = path.list(filter);
            list = path.list( ( dir, name ) -> name.endsWith(".jpg") || name.endsWith(".JPG"));
        }
//        for(String dir : list){
//            System.out.println(dir);
//        }
//        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        Stream.of(list).sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);
    }
}

class DirFilter  implements FilenameFilter{
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".jpg") || name.endsWith(".JPG");
    }
    //holds filtering criteria

}
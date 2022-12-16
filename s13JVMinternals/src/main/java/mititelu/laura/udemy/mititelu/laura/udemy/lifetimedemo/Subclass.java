package mititelu.laura.udemy.mititelu.laura.udemy.lifetimedemo;

public class Subclass extends Superclass implements SuperInterface{

    public static final int STATIC_FINAL = 47; //compile time constant
    public static final int STATIC_FINAL2 = (int)(Math.random() * 5);

    static String stringLiteral = "hello";
//    public static int STATIC_FINAL4 = new ClassInitializationDemo().getInt();

    ObjectReference objectReference = new ObjectReference();

    static {
        System.out.println("Subclass : static initializer");
        //staticFinal = 47;
    }

    public Subclass(){
        System.out.println("Subclass : constructor");
    }

    //Instance initializer is copied to the beginning of constructor by compiler
    {
        System.out.println("Subclass: instance initializer");
    }

}

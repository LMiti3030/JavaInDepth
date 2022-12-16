package mititelu.laura.udemy.mititelu.laura.udemy.lifetimedemo;

/**
 * Demonstrates,
 * (i) class is NOT loaded on accessing a compile-time constant. Constant is fetched from .class file
 * (ii) On Accessing a non-compile constant, class & its superclass are LOADED and INITIALIZED
 * (iii) On instantiating the class, it is loaded from memory (loading was done previous step) and
 *      a) superclass constructor is run, ie, CONSTRUCTOR CHAINING
 *      b) its instance variables are initialized and instance initializer block is run
 *      c) its own constructor is run
 */

public class ClassInitializationDemo {
    {
        System.out.println("\nClassInitializationDemo: instance initializer");
    }

    static{
        System.out.println("\nClassInitializationDemo: static initializer (Initialization stage)");
    }

    static int getInt(){
        System.out.println("ClassInitializationDemo: getInt()");
        return 3;
    }

    static int getInt5(){
        System.out.println("ClassInitializationDemo: getInt5()");
        return 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\nJVM invoked the main method ...");
        System.out.println("Subclass.STATIC_FINAL: " + Subclass.STATIC_FINAL); //subclass not loaded as STATIC_FINAL is  compile time constant
        //System.out.println("Subclass.stringLiteral: "+ Subclass.stringLiteral);
        System.out.println(("Invoking Subclass.STATIC_FINAL2 ..."));
        System.out.println("Subclass.STATIC_FINAL2: " + Subclass.STATIC_FINAL2); //Superinterface is also loaded but is not initialized!!
        System.out.println("\nInstantiating Subclass...");
        new Subclass();
        System.out.println("SuperInterface.STATIC_FINAL3: "+ SuperInterface.STATIC_FINAL3 );
        SuperInterface.staticMethod();

    }

}

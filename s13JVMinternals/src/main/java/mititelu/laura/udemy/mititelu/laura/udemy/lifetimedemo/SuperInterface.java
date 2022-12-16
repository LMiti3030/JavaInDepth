package mititelu.laura.udemy.mititelu.laura.udemy.lifetimedemo;

public interface SuperInterface {
    int STATIC_FINAL3 = new ClassInitializationDemo().getInt();
    int STATIC_FINAL5 = new ClassInitializationDemo().getInt5();

    static void staticMethod(){
        System.out.println("SuperInterface : staticMethod");
    }

}

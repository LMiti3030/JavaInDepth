package mititelu.laura.udemy.mititelu.laura.udemy.reflectionex;

import java.lang.reflect.Method;

public class SimpleUnitTester {

    //single parameter represented by a class called Reflection
    public int execute(Class clazz) throws Exception{
        int failedCount = 0;

        Object object = null;
        object = clazz.getDeclaredConstructor().newInstance();

        for(Method m : clazz.getDeclaredMethods() ){
            if(m.getName().startsWith("test") && m.getReturnType() == boolean.class){
                Object result =m.invoke(object);
                if(((Boolean)result).booleanValue() == false){
                    failedCount++;
                }
            }
        }

        return failedCount;
    }

}

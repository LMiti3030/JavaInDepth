package mititelu.laura.javaindepth.io;

import java.io.*;

public class SerializationDemo {

    static String inFileStr = "walden.jpg";
    static String outFileStr = "walden-out.jpg";

    public static class SerializableObject implements Serializable {

        static final long serialVersionUID = 5133515596480010241L;
        private String name;
        private transient int id = 4;

        private String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        if(args.length > 0 && args[0].equals("true")){
            new SerializationDemo().doSerialization();

        }
        new SerializationDemo().doDeserialization();
    }





    private void doSerialization() {

        System.out.println("\nInside doSerialization..");
        SerializableObject serializableObject = new SerializableObject();
        serializableObject.setName("Java");
        System.out.println("name (before serialization): " + serializableObject.getName());
        System.out.println("id (before serialization): " + serializableObject.getId());

        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream("serial.ser")
        ))){
            out.writeObject(serializableObject);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doDeserialization() {
        System.out.println("\nInside doDeserialization..");

        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("serial.ser")
        ))) {
            SerializableObject serializableObject = (SerializableObject) in.readObject();
            System.out.println("name (after serialization): " + serializableObject.getName());
            System.out.println("id (after serialization): " + serializableObject.getId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

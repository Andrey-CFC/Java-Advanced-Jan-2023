package L07StreamsFilesAndDirectories;

import java.io.*;

public class P09SerializeCustomObject {
    public static class Cube implements Serializable {
        private String colour;
        private double width;
        private double height;
        private double depth;

        public Cube(String colour, double width, double height, double depth) {
            this.colour = colour;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);
        String path = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\save.ser";
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(cube);
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(path));
        Cube deserializedCube = (Cube) ios.readObject();
        System.out.println();
    }
}
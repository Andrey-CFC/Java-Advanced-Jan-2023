package L15Generics.P01JarOfTar;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<Integer>();

        jar.add(150);
        System.out.println(jar.remove());

    }
}

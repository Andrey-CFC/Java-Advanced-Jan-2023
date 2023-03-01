package L15Generics.P03GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(85, 95);
        System.out.println(scale.getHeavier());
    }
}

package L19WorkshopAlgorithmsIntroduction;

public class Main {
    public static void main(String[] args) {

        System.out.println(pow(2,5));
    }

    private static int pow(int num, int power) {
        if (power == 1) {
            return num;
        }
        return num * pow(num, power - 1);
    }
}

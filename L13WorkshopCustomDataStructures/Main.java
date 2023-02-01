package L13WorkshopCustomDataStructures;

public class Main {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(5);
        customStack.push(3);
        customStack.push(76);
        customStack.push(7);
        customStack.push(55);
        customStack.push(56);
        customStack.push(12);
        customStack.push(1);
        customStack.forEach(e-> System.out.print(e));
    }
}

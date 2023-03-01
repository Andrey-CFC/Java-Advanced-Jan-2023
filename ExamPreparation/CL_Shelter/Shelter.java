package ExamPreparation.CL_Shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (this.capacity > this.data.size()) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(a -> a.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream().filter(a ->  a.getName().equals(name) && a.getCaretaker().equals(caretaker)).findAny().orElse(null);
    }

    public Animal getOldestAnimal() {
        return data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        this.data.forEach(animal-> sb.append(animal.getName()).append(" ").append(animal.getCaretaker()).append(System.lineSeparator()));
        return sb.toString();
    }
}

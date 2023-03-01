package ExamPreparation.CL_Rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.capacity > this.data.size()) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        Rabbit rabbit = this.data.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
        return this.data.remove(rabbit);
    }

    public void removeSpecies(String species) {
        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = this.data.stream().filter(r -> r.getName().equals(name)).findFirst().orElseThrow();
        rabbit.setAvailable(false);
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = this.data.stream().filter(r -> r.getSpecies().equals(species)).collect(Collectors.toList());
        rabbits.forEach(rabbit -> rabbit.setAvailable(false));
        return rabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        List<Rabbit> rabbits = this.data.stream().filter(Rabbit::isAvailable).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Rabbits available at %s:", getName()));
        rabbits.forEach(r -> {
            builder.append(System.lineSeparator());
            builder.append(r.toString());
        });
        return builder.toString();
    }
}

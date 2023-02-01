package L12DefiningClassesEx.P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parentList;
    private List<Child> childList;
    private List<Pokemon> pokemonList;

    public Person(String name) {
        this.name = name;
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParentList() {
        return this.parentList;
    }

    public List<Child> getChildList() {
        return this.childList;
    }

    public List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }

    public String getOutputForCompany(Company company) {
        if (company != null) {
            return String.format("Company:%n%s %s %.2f", this.company.getCompanyName(), this.company.getDepartment(), this.company.getSalary());
        } else {
            return "Company:";
        }
    }

    public String getOutputForCar(Car car) {
        if (car != null) {
            return String.format("Car:%n%s %d", this.car.getModel(), car.getSpeed());
        } else {
            return "Car:";
        }
    }

    public String getOutputForParent(List<Parent> parentList){
        if (!parentList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Parents:%n"));
            for (Parent parent : parentList) {
                sb.append(String.format("%s%n", parent.toString()));
            }
            return String.format("%s", sb);
        } else {
            return String.format("Parents:%n");
        }
    }

    public String getOutputForPokemon(List<Pokemon> pokemonList) {
        if (!pokemonList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Pokemon:%n"));
            for (Pokemon pokemon : pokemonList) {
                sb.append(String.format("%s%n", pokemon.toString()));
            }
            return String.format("%s", sb);
        } else {
            return String.format("Pokemon:%n");
        }
    }

    public String getOutputForChildren(List<Child> childList) {
        if (!childList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Children:%n"));
            for (Child child : childList) {
                sb.append(String.format("%s%n", child.toString()));
            }
            return String.format("%s", sb);
        } else {
            return String.format("Children:%n");
        }
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n%s%s%s", this.name, getOutputForCompany(company), getOutputForCar(car), getOutputForPokemon(pokemonList), getOutputForParent(parentList), getOutputForChildren(childList));
    }
}

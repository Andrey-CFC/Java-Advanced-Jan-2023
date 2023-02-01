package L12DefiningClassesEx.P08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parentsList;
    private List<Person> childrenList;


    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void addToParentList(Person person) {
        if (isNew(person, parentsList)) {
            this.parentsList.add(person);
        }
    }

    public void addToChildrenList(Person person) {
        if (isNew(person, childrenList)) {
            this.childrenList.add(person);
        }
    }

    public boolean isNew(Person person, List<Person> personList) {
        for (Person currentGuy : personList) {
            if (currentGuy.equals(person)) {
                return false;
            }
        }
        return true;
    }

    public String getOutputForList(List<Person> list) {
        StringBuilder sb = new StringBuilder();
        if (!list.isEmpty()) {
            for (Person currentGuy : list) {
                sb.append(String.format("%s %s%n", currentGuy.getName(), currentGuy.getBirthday()));
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s%nParents:%n%sChildren:%n%s", this.name, String.join("/", this.birthday), getOutputForList(this.parentsList), getOutputForList(this.childrenList));
    }

}

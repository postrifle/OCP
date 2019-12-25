package OCP8.chapter3.additionsinjava8;

import java.util.Objects;


public class Duck {
    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Duck)) return false;
        Duck duck = (Duck) o;
        return getWeight() == duck.getWeight() &&
                getName().equals(duck.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int compareByName(Duck d1, Duck d2){
        return d1.getName().compareTo(d2.getName());
    }
}

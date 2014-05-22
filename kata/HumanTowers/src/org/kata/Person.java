package org.kata;

public class Person {

    private int height;
    private int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    public boolean compatible(Person person2) {
        return getHeight() == person2.getHeight() && getWeight() >= person2.getWeight();
    }
}

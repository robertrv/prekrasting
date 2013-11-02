package org.kata;

/**
 * Created with IntelliJ IDEA.
 * User: rramirez
 * Date: 10/24/13
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {

    private int height;
    private int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public static Person build(int height, int weight) {
        return new Person(height, weight);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

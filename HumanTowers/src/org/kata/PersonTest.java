package org.kata;

public class PersonTest {


    public static void main(String[] args) {
        new PersonTest().execute();
    }

    private void execute() {
        Person man = new Man(69,69);
        sayHello((Man) man);

        Woman woman = new Woman(11, 11);
        sayHello(woman);
    }

    private void sayHello(Woman woman) {
        System.out.println("I am a woman!: " + woman);
    }

    private void sayHello(Man man) {
        System.out.println("I am a man!: " + man);
    }

}

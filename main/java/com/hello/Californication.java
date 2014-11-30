package com.hello;

public class Californication implements Greeting {
    @Override
    public String sayHello(String who) {
        return String.format("Hello Motherfuckeer! akka %s", who);
    }
}

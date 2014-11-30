package com.hello;

public class Bro implements Greeting {


    @Override
    public String sayHello(String who) {
        return String.format("Hey Bro! What's up %s?", who);
    }
}

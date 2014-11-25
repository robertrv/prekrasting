package com.hello;

public class World implements Greeting {

    @Override
    public String sayHello(String who) {
        return String.format("Hello %s", who);
    }
}

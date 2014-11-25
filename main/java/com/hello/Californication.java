package com.hello;

/**
 * Created by viquer on 11/17/14.
 */
public class Californication implements Greeting {
    @Override
    public String sayHello(String who) {
        return String.format("Hello Motherfuckeer! akka %s", who);
    }
}

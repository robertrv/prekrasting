package com.hello;

/**
 * Created by viquer on 11/18/14.
 */
public class Bro implements Greeting {


    @Override
    public String sayHello(String who) {
        return String.format("Hey Bro! What's up %s?", who);
    }
}

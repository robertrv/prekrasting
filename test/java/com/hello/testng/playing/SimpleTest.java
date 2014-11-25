package com.hello.testng.playing;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyMethodInterceptor.class})
public class SimpleTest {

    @Test
    public void simple() {
        System.out.println("Hello world");
    }

    @Test
    public void A() {
        System.out.println("Hello A");

    }

    @Test
    public void C() {
        System.out.println("Hello C");

    }

    @Test
    public void B() {
        System.out.println("Hello B");

    }

    @Test
    public void Aaa() {
        System.out.println("Hello Aaa");

    }
}

package com.hello.running.parallel.testng;

import java.lang.reflect.Method;

import org.joda.time.LocalTime;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NonParallel {

    private Method testMethod;

    @BeforeMethod
    public void handleTestMethodName(Method method) {
        this.testMethod = method;
    }

    @Test
    public void a() throws Exception {
        print("a");
    }

    @Test
    public void b() throws Exception {
        print("b");
    }

    @Test
    public void c() throws Exception {
        print("c");
        Assert.fail();
    }

    private void print(String msg) throws InterruptedException {
        String toPrint = String.format("%s: %s.%s.[%s]", LocalTime.now(), getClass().getSimpleName(), msg, testMethod.getName());
        System.out.println(toPrint);
    }
}

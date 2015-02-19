package com.hello.running.parallel.testng;

import org.joda.time.LocalTime;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public abstract class BaseParallelSuite {

    private Logger logger = Logger.getLogger(getClass().getName());

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
    }

    private void print(String msg) throws InterruptedException {
        Thread.sleep((long)(Math.random()*1000));
        String toPrint = String.format("%s: %s.%s", LocalTime.now(), getClass().getSimpleName(), msg);
        System.out.println(toPrint);
        logger.info(toPrint);
    }

    public static class Test1 extends BaseParallelSuite {

    }

    public static class Test2 extends BaseParallelSuite {

    }

    public static class Test3 extends BaseParallelSuite {

    }
}

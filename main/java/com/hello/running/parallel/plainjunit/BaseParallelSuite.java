package com.hello.running.parallel.plainjunit;

import org.joda.time.LocalTime;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

@RunWith(ParallelRunner.class)
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
}

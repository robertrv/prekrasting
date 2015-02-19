package com.hello.running.parallel.junittoolbox.tests;

import com.googlecode.junittoolbox.ParallelRunner;
import com.hello.running.parallel.junittoolbox.categories.Canary;
import org.joda.time.LocalTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

@Ignore
@RunWith(ParallelRunner.class)
public abstract class Base {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Test
    public void a() throws Exception {
        print("a");
    }

    @Test
    @Category(Canary.class)
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
        // logger.info(toPrint);
    }

}

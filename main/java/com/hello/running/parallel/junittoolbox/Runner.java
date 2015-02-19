package com.hello.running.parallel.junittoolbox;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Runner {

    public static void main(String[] args) {
        testNGByCode();
    }

    private static void testNGByCode() {
        System.setProperty("maxParallelTestThreads", "1");
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{ Suites.Canaries.class });
        testng.addListener(tla);
        testng.setJUnit(true);

        testng.setOutputDirectory("test-output");
        testng.run();
    }
}

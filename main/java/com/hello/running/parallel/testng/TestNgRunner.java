package com.hello.running.parallel.testng;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class TestNgRunner {

    private static Class[] cls = { BaseParallelSuite.Test1.class, BaseParallelSuite.Test2.class, BaseParallelSuite.Test3.class };

    public static void main(String[] args) {
        testNGByCode();
    }

    private static void testNGByCode() {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(cls);
        testng.addListener(tla);
        testng.setThreadCount(6);
        testng.setParallel("instances");
        testng.setOutputDirectory("test-output");
        testng.run();
    }
}

package com.hello.running.parallel.plainjunitWithConcurrent;

import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class JunitRunner {

//    private static Class[] cls = { ParallelTest1.class, ParallelTest2.class, ParallelTest3.class };
    private static Class[] cls = { MySuite.class };

    public static void main(String[] args) {
//        runJunitUsingParallelComputer();
        runJunitUsingTestNg();
    }

    private static void runJunitUsingParallelComputer() {
        //Parallel among classes
        JUnitCore.runClasses(ParallelComputer.classes(), cls);
        System.out.println("just classes");

        //Parallel among methods in a class
        JUnitCore.runClasses(ParallelComputer.methods(), cls);
        System.out.println("methods");

        //Parallel all methods in all classes
        JUnitCore.runClasses(new ParallelComputer(true, true), cls);
        System.out.println("all");
    }

    private static void runJunitUsingTestNg() {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(cls);
        testng.addListener(tla);
        testng.setJUnit(true);
        testng.setThreadCount(6);
        testng.setParallel("classes");
//        testng.setSuiteThreadPoolSize(6);
//        testng.setDataProviderThreadCount(6);
//        testng.setThreadCount(6);
        testng.setOutputDirectory("test-output");
        testng.run();
    }
}
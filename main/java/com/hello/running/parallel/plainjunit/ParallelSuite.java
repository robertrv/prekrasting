package com.hello.running.parallel.plainjunit;


import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class ParallelSuite {

    private static Class[] cls = { ParallelTest1.class, ParallelTest2.class };

    @Test
    public void main() {
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
}

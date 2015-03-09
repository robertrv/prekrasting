package com.hello.running.parallel.testng;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.MethodInfo;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestNgRunner {

    //private static Class[] cls = {NonParallel.class};
            // { BaseParallelSuite.Test1.class, BaseParallelSuite.Test2.class, BaseParallelSuite.Test3.class };

    public static void main(String[] args) throws Exception {
        testNGByCode();
    }

    private static void testNGByCode() throws Exception {
        Class cl = duplicateTestMethods("com.hello.running.parallel.testng.NonParallel");
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{cl});
        testng.addListener(tla);
        testng.setThreadCount(6);
        testng.setParallel("instances");
        testng.setOutputDirectory("test-output");
        testng.run();
    }

    private static Class duplicateTestMethods(String className) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get(className);
        CtMethod[] methods = ctClass.getMethods();
        for (CtMethod method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                String methodName = method.getName();
                method.setName(methodName + "_modified");
                MethodInfo methodInfo = method.getMethodInfo();
                CtMethod other = CtMethod.make(methodInfo, ctClass);
                other.setName(methodName + "_other");
                //ctClass.addMethod(other);
                //ctClass.addMethod(method);
            }
        }
        return ctClass.toClass();
    }
}

package com.hello.testng.playing;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by viquer on 11/20/14.
 */
public class MyMethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        System.out.printf("Intecepting! " + methods);
        List<IMethodInstance> result = new LinkedList<IMethodInstance>();

        for (IMethodInstance method : methods) {
            result.add(method);
            result.add(method);
        }
        return result;
    }
}

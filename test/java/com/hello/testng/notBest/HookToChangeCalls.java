package com.hello.testng.notBest;

import com.hello.annotations.BroWay;
import com.hello.annotations.CalifornicationWay;
import com.hello.annotations.WorldWay;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.ConstructorOrMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;

public abstract class HookToChangeCalls implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        if (isInterestingMethod(testResult.getMethod())
                && InitializeBaseOnAnnotationListener.class.isAssignableFrom(testResult.getInstance().getClass())) {
            InitializeBaseOnAnnotationListener listener = (InitializeBaseOnAnnotationListener) testResult.getInstance();

            for (Class<? extends Annotation> annotation : getRegisteredAnnotations()) {
                if (hasAnnotation(testResult, annotation)) {
                    listener.initialize(annotation);
                    callBack.runTestMethod(testResult);
                }
            }
        } else {
            callBack.runTestMethod(testResult);
        }
    }

    protected abstract Collection<? extends Class<? extends Annotation>> getRegisteredAnnotations();

    private boolean hasAnnotation(ITestResult testResult, Class<? extends Annotation> annotation) {
        ConstructorOrMethod com = testResult.getMethod().getConstructorOrMethod();
        if (com.getMethod() == null) {
            throw new IllegalStateException(String.format("%s cannot be added to a constructor", annotation));
        } else {
            return com.getMethod().getAnnotation(annotation) != null;
        }
    }

    private boolean isInterestingMethod(ITestNGMethod testNGMethod) {
        Method method = testNGMethod.getConstructorOrMethod().getMethod();
        if (method != null) {
            return  method.getAnnotation(BroWay.class) != null ||
                    method.getAnnotation(CalifornicationWay.class) != null ||
                    method.getAnnotation(WorldWay.class) != null;
        } else {
            return false;
        }
    }
}

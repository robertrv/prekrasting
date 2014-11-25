package com.hello.junit;

import com.hello.annotations.BroWay;
import com.hello.annotations.CalifornicationWay;
import com.hello.annotations.GreetingAnnotation;
import com.hello.annotations.WorldWay;
import org.junit.runner.Description;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import javax.annotation.Nonnull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InjectAnnotationRunner extends BlockJUnit4ClassRunner {

    private static final List<Class<? extends Annotation>> annotations =
            Arrays.asList(WorldWay.class, CalifornicationWay.class, BroWay.class);

    public InjectAnnotationRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List<FrameworkMethod> getChildren() {
        List<FrameworkMethod> children = super.getChildren();
        List<FrameworkMethod> result = new LinkedList<FrameworkMethod>();
        for (FrameworkMethod child : children) {
            for (Class<? extends Annotation> annotation : annotations) {
                prepareAnnotation(result, child, annotation);
            }
        }
        return result;
    }

    private void prepareAnnotation(List<FrameworkMethod> result, FrameworkMethod child, Class<? extends Annotation> annotationType) {
        if (child.getAnnotation(annotationType) != null) {
            result.add(cloneMethod(child.getMethod(), annotationType));
        }
    }

    private FrameworkMethod cloneMethod(Method method, final Class<? extends Annotation> toKeep) {
        return new FrameworkMethod(method){
            @Override
            public Annotation[] getAnnotations() {
                Annotation[] annotations = super.getAnnotations();
                List<Annotation> result = new LinkedList<Annotation>();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getAnnotation(GreetingAnnotation.class) == null ||
                            annotation.annotationType().equals(toKeep)) {
                        result.add(annotation);
                    }
                }
                return result.toArray(new Annotation[result.size()]);
            }
        };
    }

    @Override
    protected Description describeChild(FrameworkMethod method) {
        Description superDescription = super.describeChild(method);
        String displayName = superDescription.getMethodName();

        displayName += resolveAnnotationName(method);

        return Description.createTestDescription(superDescription.getTestClass(), displayName, resolveAnnotation(method));
    }

    private String resolveAnnotationName(@Nonnull FrameworkMethod method) {
        return resolveAnnotation(method).toString();
    }

    private Annotation resolveAnnotation(FrameworkMethod method) {
        for (Class<? extends Annotation> annotation : annotations) {
            if (method.getAnnotation(annotation) != null) {
                return method.getAnnotation(annotation);
            }
        }
        throw new IllegalStateException("Should never happen");
    }
}

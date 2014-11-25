package com.hello.testng.infraestructure;

import com.hello.annotations.GreetingAnnotation;
import org.reflections.Reflections;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Will be transforming @Test method annotation to get provided information.
 *
 * This listener just listen to @Test annotations.
 */
public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod != null) {
            if (!annotation.getDataProvider().isEmpty() || annotation.getDataProviderClass() != null) {
                if (filterUsefulAnnotations(testMethod).size() == 1) {
                    // TODO make it work with data provider if there is just one annotation which we are interested in.
                }
                throw new IllegalStateException("Cannot work with data providers | provider class");
            }
            annotation.setDataProviderClass(StaticDataProvider.class);
            annotation.setDataProvider(StaticDataProvider.PROVIDER_NAME);
        }
    }

    public static Queue<Class<? extends Annotation>> filterUsefulAnnotations(Method method) {
        Queue<Class<? extends Annotation>> result = new LinkedList<Class<? extends Annotation>>();
        for (Class<?> clazz : annotations) {
            Class<? extends Annotation> annotation = (Class<? extends Annotation>) clazz;
            if (method.getAnnotation(annotation) != null) {
                result.add(annotation);
            }
        }
        return result;
    }

    private static Set<Class<?>> annotations;
    static {
        Reflections reflections = new Reflections(GreetingAnnotation.class.getPackage().getName());
        annotations = reflections.getTypesAnnotatedWith(GreetingAnnotation.class);
    }
}

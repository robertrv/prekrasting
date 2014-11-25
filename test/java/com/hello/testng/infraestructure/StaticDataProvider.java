package com.hello.testng.infraestructure;

import org.testng.annotations.DataProvider;
import org.testng.annotations.TestInstance;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Queue;

/**
 * Externalize the data providing
 */
public class StaticDataProvider {
    static final String PROVIDER_NAME = "injectedProvider";

    @DataProvider(name = PROVIDER_NAME)
    public static Object[][] provider(Method method, @TestInstance Object instance) {
        if (!AnnotationQueueListener.class.isAssignableFrom(instance.getClass())) {
            throw new IllegalArgumentException("Test instance must implement the proper interface");
        } else {
            Queue<Class<? extends Annotation>> annotations = AnnotationTransformer.filterUsefulAnnotations(method);

            AnnotationQueueListener initializer = (AnnotationQueueListener) instance;
            initializer.initialize(annotations);

            Object[][] result = new Object[annotations.size()][0];
            for (int i = 0; i < result.length; i++) {
                result[i] = new Object[]{};
            }
            return result;
        }
    }
}

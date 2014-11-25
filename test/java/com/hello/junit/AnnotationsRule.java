package com.hello.junit;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.lang.annotation.Annotation;
import java.util.Collection;

public class AnnotationsRule extends TestWatcher {
    private Description description;

    @Override
    protected void starting(Description description) {
        this.description = description;
    }

    public boolean contains(Class<? extends Annotation> annotationClass) {
        return description.getAnnotation(annotationClass) != null;
    }

    public Collection<Annotation> getAnnotations() {
        return description.getAnnotations();
    }
}

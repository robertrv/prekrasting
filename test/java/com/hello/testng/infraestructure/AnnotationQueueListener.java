package com.hello.testng.infraestructure;


import java.lang.annotation.Annotation;
import java.util.Queue;

public interface AnnotationQueueListener {
    void initialize(Queue<Class<? extends Annotation>> annotations);
}

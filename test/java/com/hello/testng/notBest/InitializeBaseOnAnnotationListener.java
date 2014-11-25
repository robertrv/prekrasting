package com.hello.testng.notBest;


import java.lang.annotation.Annotation;

interface InitializeBaseOnAnnotationListener {
    void initialize(Class<? extends Annotation> annotation);
}

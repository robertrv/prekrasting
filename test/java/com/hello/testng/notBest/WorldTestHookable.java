package com.hello.testng.notBest;

import com.hello.Bro;
import com.hello.Californication;
import com.hello.Greeting;
import com.hello.World;
import com.hello.annotations.BroWay;
import com.hello.annotations.CalifornicationWay;
import com.hello.annotations.GreetingAnnotation;
import com.hello.annotations.WorldWay;
import org.reflections.Reflections;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Set;

public class WorldTestHookable extends HookToChangeCalls implements InitializeBaseOnAnnotationListener {

    private static Set annotations;

    static {
        Reflections reflections = new Reflections(GreetingAnnotation.class.getPackage().getName());
        annotations = reflections.getTypesAnnotatedWith(GreetingAnnotation.class);
    }
    private Greeting greeter;

    @WorldWay
    @CalifornicationWay
    @BroWay
    @Test(enabled = false)
    public void helloBro() {
        System.out.println("Proper test " + greeter.sayHello("Mum"));
    }

    @WorldWay
    @Test(enabled = false)
    public void otherSayHello() {
        System.out.println("Here we go!" + greeter.sayHello("Mum"));
    }

    @Override
    public void initialize(Class<? extends Annotation> annotation) {
        if (BroWay.class.equals(annotation)) {
            greeter = new Bro();
        } else if (CalifornicationWay.class.equals(annotation)) {
            greeter = new Californication();
        } else if (WorldWay.class.equals(annotation)) {
            greeter = new World();
        } else {
            throw new IllegalStateException("Could not initialize this type");
        }
    }

    @Override
    protected Collection<? extends Class<? extends Annotation>> getRegisteredAnnotations() {
        return annotations;
    }
}

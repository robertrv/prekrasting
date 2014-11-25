package com.hello.testng;

import com.hello.Bro;
import com.hello.Californication;
import com.hello.Greeting;
import com.hello.World;
import com.hello.annotations.BroWay;
import com.hello.annotations.CalifornicationWay;
import com.hello.annotations.WorldWay;
import com.hello.testng.infraestructure.AnnotationQueueListener;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Queue;

import static org.testng.Assert.assertTrue;

public class WorldTest implements ITest, AnnotationQueueListener {

    private Greeting greeter;

    @WorldWay
    @CalifornicationWay
    @BroWay
    @Test
    public void helloBro() {
        System.out.println("Proper test " + greeter.sayHello("Mum"));
        assertTrue(testName.contains(greeter.getClass().getSimpleName()));
    }

    @WorldWay
    @Test
    public void myself_alaWorld() {
        Assert.assertEquals("Hello myself", greeter.sayHello("myself"));
    }

    @CalifornicationWay
    @Test
    public void myself_alaCalifornication() {
        Assert.assertEquals("Hello Motherfuckeer! akka myself", greeter.sayHello("myself"));
    }

    @BroWay
    @Test
    public void myself_alaBro() {
        Assert.assertEquals("Hey Bro! What's up myself?", greeter.sayHello("myself"));
    }

    @Override
    public String getTestName() {
        return testName;
    }

    private String testName;
    private Queue<Class<? extends Annotation>> annotations;

    @BeforeMethod
    public void prepare(Method method) {
        greeter = createGreeting(annotations.remove());
        testName = String.format("%s_%s", method.getName(), greeter.getClass().getSimpleName());
    }

    @Override
    public void initialize(Queue<Class<? extends Annotation>> annotations) {
        this.annotations = annotations;
    }

    private Greeting createGreeting(Class<? extends Annotation> annotation) {
        if (BroWay.class.equals(annotation)) {
            return new Bro();
        } else if (CalifornicationWay.class.equals(annotation)) {
            return new Californication();
        } else if (WorldWay.class.equals(annotation)) {
            return new World();
        } else {
            throw new IllegalStateException("Could not initialize this type, your test must be annotated with TestNG @Test annotation and the ");
        }
    }
}

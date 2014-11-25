package com.hello.junit;

import com.hello.Bro;
import com.hello.Californication;
import com.hello.Greeting;
import com.hello.World;
import com.hello.annotations.BroWay;
import com.hello.annotations.CalifornicationWay;
import com.hello.annotations.WorldWay;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(InjectAnnotationRunner.class)
public class WorldTest {

    private Greeting greeter;

    @Rule
    public AnnotationsRule annotations = new AnnotationsRule();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("\t\tBefore class ");
    }

    @Before
    public void before() {
        if (annotations.contains(CalifornicationWay.class)) {
            greeter = new Californication();
        } else if (annotations.contains(WorldWay.class)) {
            greeter = new World();
        } else if (annotations.contains(BroWay.class)) {
            greeter = new Bro();
        } else {
            throw new IllegalStateException("Not greeter found");
        }
    }

    @WorldWay
    @CalifornicationWay
    @BroWay
    @Test
    public void helloAllStyles() {
        System.out.println("\tProper test " + greeter.sayHello("Mum"));
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

}

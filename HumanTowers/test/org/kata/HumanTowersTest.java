package org.kata;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rramirez
 * Date: 10/24/13
 * Time: 7:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class HumanTowersTest {
    HumanTowers towers;
    @Before
    public void setUp() {
       towers = new HumanTowers();
    }

    @Test
    public void empty(){
        int level = towers.level(Collections.EMPTY_LIST);
        Assert.assertEquals(0, level);
    }

    @Test
    public void one() {
        int level = towers.level(Arrays.asList(new Person(1,1)));
        Assert.assertEquals(1, level);
    }

    @Test
    public void two(){
        int level = towers.level(Arrays.asList(new Person(1,1), new Person(2,2)));
        Assert.assertEquals(2, level);
    }

    @Test
    public void twoComplex() {
        int level = towers.level(Arrays.asList(new Person(1,1), new Person(1 ,1)));
        Assert.assertEquals(1, level);
    }
}

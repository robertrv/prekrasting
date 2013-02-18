package org.home.kata;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: robert
 * Date: 2/15/13
 * Time: 8:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class KarateChopTest {

    @Test(groups = "MyGroup")
    void negativeCases() {
        Assert.assertEquals(KarataChop.binarySearch(new Integer[]{1, 2, 3}, 22), -1);
        Assert.assertEquals(KarataChop.binarySearch(new Integer[]{}, 22), -1);
        Assert.assertEquals(KarataChop.binarySearch(new Integer[]{1, 2, 3},-1), 2);
    }

}

package org.home.kata;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author robertrv [at] gmail.com
 * Date: 2/15/13
 */
public class KarateChopTest {

    @Test(groups = "kata")
    public void positiveCases() {
        Assert.assertEquals(1,  KarataChop.binarySearch(3, new Integer[]{1, 3, 5}));
        Assert.assertEquals(2,  KarataChop.binarySearch(5, new Integer[]{1, 3, 5}));
        Assert.assertEquals(-1, KarataChop.binarySearch(0, new Integer[]{1, 3, 5}));
        Assert.assertEquals(-1, KarataChop.binarySearch(2, new Integer[]{1, 3, 5}));
        Assert.assertEquals(-1, KarataChop.binarySearch(4, new Integer[]{1, 3, 5}));
        Assert.assertEquals(-1, KarataChop.binarySearch(6, new Integer[]{1, 3, 5}));
        Assert.assertEquals(0,  KarataChop.binarySearch(1, new Integer[]{1, 3, 5, 7}));
        Assert.assertEquals(1,  KarataChop.binarySearch(3, new Integer[]{1, 3, 5, 7}));
        Assert.assertEquals(2,  KarataChop.binarySearch(5, new Integer[]{1, 3, 5, 7}));
        Assert.assertEquals(3,  KarataChop.binarySearch(7, new Integer[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, KarataChop.binarySearch(0, new Integer[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, KarataChop.binarySearch(2, new Integer[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, KarataChop.binarySearch(4, new Integer[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, KarataChop.binarySearch(6, new Integer[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, KarataChop.binarySearch(8, new Integer[]{1, 3, 5, 7}));
    }

    @Test(groups = "kata")
    public void negativeCases() {
        Assert.assertEquals(KarataChop.binarySearch(22, new Integer[]{1, 2, 3}), -1);
        Assert.assertEquals(KarataChop.binarySearch(22, new Integer[]{}), -1);
        Assert.assertEquals(KarataChop.binarySearch(-1, new Integer[]{1, 2, 3}), -1);
        Assert.assertEquals(-1, KarataChop.binarySearch(3, new Integer[]{}));
        Assert.assertEquals(-1, KarataChop.binarySearch(3, new Integer[]{1}));
    }

    @Test(groups = "kata")
    public void firstItemCases() {
        Assert.assertEquals(0,  KarataChop.binarySearch(1, new Integer[]{1}));
        Assert.assertEquals(0,  KarataChop.binarySearch(1, new Integer[]{1, 3, 5}));
    }

}

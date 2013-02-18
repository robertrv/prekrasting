package org.home.kata;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: robert
 * Date: 2/15/13
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class KarataChop {

    /**
     * Tries to find the list passed as parameter. In case is found return its position
     * @param integerArray
     * @param toFind the element to be found
     * @return the toFind position, or -1 in case is not.
     */
    public static int binarySearch(Integer[] integerArray, Integer toFind){
        return new KarataChop().implementation1(integerArray, toFind);
    }

    private int implementation1(Integer[] integerArray, Integer toFind) {
        return -1;
    }
}

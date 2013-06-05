package org.home.kata;

/**
 * http://codekata.pragprog.com/2007/01/kata_two_karate.html
 * @author robert [at] gmail.com
 * Date: 2/15/13

 */
public class KarataChop {

    /**
     * Tries to find the list passed as parameter. In case is found return its position
     *
     * @param toFind the element to be found
     * @param integerArray
     * @return the toFind position, or -1 in case is not.
     */
    public static int binarySearch(Integer toFind, Integer[] integerArray){
        return new KarataChop().implementation2(toFind, integerArray);
    }

    /** greedy iterative search */
    private int implementation1(Integer toFind, Integer[] integerArray) {

        for (int i = 0 ; i < integerArray.length ; i++) {
            if (integerArray[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    /** iterative search */
    private int implementation2(Integer toFind, Integer[] integerArray) {

        int rightIndex = integerArray.length;
        int leftIndex = 0;

        while (rightIndex >= leftIndex ) {
            int mediumIndex = (int) Math.ceil((leftIndex+rightIndex)/2);

            if (mediumIndex >= integerArray.length) {
                return -1;
            }

            if (integerArray[mediumIndex] == toFind) {
                return mediumIndex;
            } else if (integerArray[mediumIndex] > toFind) {
                rightIndex = mediumIndex-1;
            } else if (integerArray[mediumIndex] < toFind) {
                leftIndex = mediumIndex+1;
            }
        }
        return -1;
    }

}

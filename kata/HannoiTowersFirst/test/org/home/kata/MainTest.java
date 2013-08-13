package org.home.kata;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class MainTest {

    private static final Logger logger = Logger.getLogger(MainTest.class
            .getName());

    private MainIterativeSolution cut;
    private static final int NUMBER_OF_HANOI_TO_TEST = 30;

    @DataPoints
    public static Integer[] candidates;

    static {
        ArrayList<Integer> temporal = new ArrayList<Integer>(NUMBER_OF_HANOI_TO_TEST);

        for (int i = 1; i <= NUMBER_OF_HANOI_TO_TEST; i++) {
            temporal.add(i);
        }

        candidates = temporal.toArray(new Integer[]{});
    }

    @Before
    public void init() {
        cut = new MainIterativeSolution();
        Logger.getLogger(MainIterativeSolution.class.getName()).setLevel(Level.OFF);
        Logger.getLogger(MainTest.class.getName()).setLevel(Level.INFO);
    }


    @Theory
    public void run(Integer n) {
        logger.log(Level.INFO, "---------> Going to start, with N= {0}", n);
        long start = System.currentTimeMillis();
        List<Move> result = cut.calculateOrder(n);
        float secs = (float)(System.currentTimeMillis()-start)/1000;
        printResult(result);
        assertTrue(cut.hasFinished());
        logger.log(Level.INFO, "Total time: {0} secs", secs);
    }

    private void printResult(List<Move> result) {
        if (logger.isLoggable(Level.FINEST)) {
            StringBuilder sb = new StringBuilder();
            for (Move move : result) {
                sb.append(move);
                sb.append(" ||| ");
            }

            logger.finest(sb.toString());
        }
    }
}

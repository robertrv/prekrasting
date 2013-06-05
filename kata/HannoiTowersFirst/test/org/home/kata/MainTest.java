package org.home.kata;

import static org.junit.Assert.assertTrue;

import java.util.List;
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

	@Before
	public void init() {
		cut = new MainIterativeSolution();
	}

	public static @DataPoints
	int[] candidates = { 3, 6 };

	@Theory
	public void run(int n) {
		logger.info("---------> Going to start, with N= "+ n);
		List<Move> result = cut.calculateOrder(n);
		printResult(result);
		assertTrue(cut.hasFinished());
	}

	private void printResult(List<Move> result) {
		for (Move move : result) {
			System.out.println(move);
		}
	}
}

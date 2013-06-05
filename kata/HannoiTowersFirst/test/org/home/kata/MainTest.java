package org.home.kata;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
	
	private MainIterate cut;

	@Before
	public void init() {
		cut = new MainIterate();
	}

	@Test
	public void empty() {
		List<Move> result = cut.calculateOrder(0);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void three() {
		List<Move> result = cut.calculateOrder(3);
		printResult(result);
		assert(cut.hasFinished());
	}
	
	@Test
	public void twentyThree() {
		List<Move> result = cut.calculateOrder(23);
		printResult(result);
		assert(cut.hasFinished());
	}
	
	@Test
	public void hundredTwentyThree() {
		List<Move> result = cut.calculateOrder(123);
		printResult(result);
		assert(cut.hasFinished());
	}

	private void printResult(List<Move> result) {
		for (Move move : result) {
			System.out.println(move);
		}
	}
}

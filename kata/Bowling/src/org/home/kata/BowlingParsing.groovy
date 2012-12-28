package org.home.kata

/**
 * Simple class to try to perform the kata Bowling:
 * 
 * https://github.com/12meses12katas/Abril-Bowling
 * 
 * @author robertrv
 */
class BowlingParsing {
	
	private FrameList score

	private int total

	BowlingParsing(String score) {
		if (score == null) {
			throw new IllegalArgumentException()
		}
		parseScore(score)
		total = 0
	}
	/**
	 * Construct a list 
	 * @param score
	 */
	private void parseScore(String input) {
		this.score = new FrameList(input.length())
		
		score.parseInput(input)
	}
	
	int calculate() {
		int total = 0
		for (Frame frame : score) {
			total += frame.calculateTotal()
		}
		return total
	}
}


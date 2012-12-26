package org.home.kata

/**
 * Simple class to try to perform the kata Bowling:
 * 
 * https://github.com/12meses12katas/Abril-Bowling
 * 
 * @author robertrv
 */
class Bowling {
	
	enum TRY_RESULT {STRIKE, SPARE, MISS, NUMBER}

	final String score
	private int index
	private int total

	Bowling(String score) {
		if (score == null) {
			throw new IllegalArgumentException()
		}
		this.score = score
		index = 0
		total = 0
		
	}

	int calculate() {
		while (index != score.length()) {
			consumeRoll()
		}
		return total
	}
	
	void consumeRoll() {
		switch (currentTryType()) {
			case TRY_RESULT.NUMBER:
				total += currentNumber()
				break;
	
			default:
				break;
		}
		index ++
	}
	
	TRY_RESULT currentTryType() {
		char current = currentChar()
		if ('/'.equals(current)) {
			return TRY_RESULT.SPARE
		} else if ('X'.equals(current)) {
			return TRY_RESULT.STRIKE
		} else if ('-'.equals(current)) {
			return TRY_RESULT.MISS
		} else {
			return TRY_RESULT.NUMBER
		}
	}
	
	int currentNumber() {
		return Integer.parseInt(currentChar().toString())
	}
	
	char currentChar() {
		return score.charAt(index)
	}
}


package org.home.kata

/**
 * Simple class to try to perform the kata Bowling:
 * 
 * https://github.com/12meses12katas/Abril-Bowling
 * 
 * @author robertrv
 */
class Bowling {
	
	enum TYPE {STRIKE, SPARE, MISS, NUMBER 
		int numericalValue(char value) {
			if (this == MISS) {
				return 0
			} else if (this == NUMBER) {
				return Integer.parseInt(value.toString())
			} else {
				throw new IllegalStateException("Numberical value for a type which does not need it: " 
					+ this)
			}
		}
	}

	final String score
	private int index
	private int total
	private TYPE previousFrameType

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
			consumeFrame()
		}
		return total
	}
	
	/**
	 * Will take care of all the frame, with all the possible pins + extra 
	 * pins for previous strikes or spares. 
	 */
	void consumeFrame() {
		int firstShotValue = 0
		int secondShotValue = 0
		
		TYPE firstShotType = currentTryType()
		switch (firstShotType) {
			case [TYPE.NUMBER,TYPE.MISS]:
				firstShotValue = firstShotType.numericalValue(currentChar())
				index++
				TYPE secondShotType = currentTryType()
				if (secondShotType == TYPE.SPARE) {
					secondShotValue = 10 - firstShotValue
				} else {
					// Should be numerical: miss or number, cannot be an STRIKE
					secondShotValue = secondShotType.numericalValue(currentChar())
				}
				sumExtraPreviousValues(firstShotValue, secondShotValue)
				this.previousFrameType = secondShotType
				break
	
			case TYPE.STRIKE:
				firstShotValue = 10
				sumExtraPreviousValues(firstShotValue, secondShotValue)
				this.previousFrameType = firstShotType
			default:
				break
		}
		index ++
		
		total += firstShotValue + secondShotValue
	}
	
	void sumExtraPreviousValues(int firstTryValue, int secondTryValue) {
		if (previousFrameType == TYPE.SPARE) {
			total += firstTryValue
		} else if (previousFrameType == TYPE.STRIKE) {
			total += (firstTryValue + secondTryValue)
		}
	}
		
	TYPE currentTryType() {
		char current = currentChar()
		if ('/' == current) {
			return TYPE.SPARE
		} else if ('X' == current) {
			return TYPE.STRIKE
		} else if ('-' == current) {
			return TYPE.MISS
		} else {
			return TYPE.NUMBER
		}
	}
		
	char currentChar() {
		return score.charAt(index)
	}
}


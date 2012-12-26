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
			} else if (this == STRIKE) {
				return 10
			} else {
				throw new IllegalStateException("Numberical value for a type which does not need it: " 
					+ this)
			}
		}
	}

	final String score
	private int index
	private int total
	private TYPE lastFrameType
	private boolean prePreStrike

	Bowling(String score) {
		if (score == null) {
			throw new IllegalArgumentException()
		}
		this.score = score
		index = 0
		total = 0
		prePreStrike = false
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
				sumBonus(firstShotValue, secondShotValue)
				this.lastFrameType = secondShotType
				break
	
			case TYPE.STRIKE:
				firstShotValue = 10
				sumBonus(firstShotValue, secondShotValue)
				this.lastFrameType = firstShotType
			default:
				break
		}
		index ++
		
		total += firstShotValue + secondShotValue
		
		if (isLastFrameBonus()) {
			sumLastFrameBonus()
		}
	}
	
	/**
	 * If current is not an strike or previous was not an STRIKE, we have
	 * played two shots, so simply add bonus depending on the lastFrameType:
	 * 		SPARE bonus: firstShot
	 * 		STRIKE bonus: first + second shots
	 *
	 * If current previous was an strike, and previous previous was an strike:
	 * 		Add extra bonus: first show
	 *
	 * To know that we are on this situation, save on prePreStrike that we did
	 * not "bonused" all
	 */
	private void sumBonus(int firstTryValue, int secondTryValue) {
		TYPE currentType = currentTryType()
		
		if (lastFrameType == TYPE.SPARE) {
			total += firstTryValue
		} else if (lastFrameType == TYPE.STRIKE) {
			total += (firstTryValue + secondTryValue)
		}
		
		if (prePreStrike) {
			total += firstTryValue
		}
		
		prePreStrike = lastFrameType == TYPE.STRIKE && currentType == TYPE.STRIKE
		
	}
		
	private boolean isLastFrameBonus() {
		boolean isLast = false
		
		if (lastFrameType == TYPE.SPARE) {
			isLast = this.score.length() == index + 1
		} else if (lastFrameType == TYPE.STRIKE) {
			isLast = this.score.length() == index + 2
		}
		return isLast;
	}
	
	/**
	 * We are on the last frame and can have previous values as SPARE or STRIKE.
	 * If is SPARE should treat last shot as a "normal" spare
	 * IF is a STRIKE, should treat first shot a a "normal" STRIKE, but last one just as numerical. 
	 */
	private void sumLastFrameBonus() {

		// "Normal" treatment for the first shot
		TYPE last = currentTryType()
		// can be just: NUMBER, MISS or STRIKE (not spare!)
		int first = last.numericalValue(currentChar())
		sumBonus(first, 0)
		
		if (lastFrameType == TYPE.STRIKE) {
			index ++ 
			last = currentTryType()
			if (last == TYPE.SPARE) {
				total += (10 - first)
			} else {
				total += last.numericalValue(currentChar())
			}
		}
		index ++

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


package org.home.kata

public enum Type {
	STRIKE, SPARE, MISS, NUMBER;
	
	int numericalValue(char value) {
		if (this == MISS) {
			return 0;
		} else if (this == NUMBER) {
			return Integer.parseInt(value.toString());
		} else if (this == STRIKE) {
			return 10
		} else {
			throw new IllegalStateException("Numberical value for a type which does not have it: "
				+ this)
		}
	}
	
	int bonusToApply() {
		int bonus = 0
		
		if (this == STRIKE) {
			bonus = 2
		} else if (this == SPARE) {
			bonus = 1
		}
		
		return bonus
	}
	
	boolean canGetNumerical() {
		return this != SPARE
	}
	
	boolean needASecondShot() {
		return this != Type.STRIKE
	}
	
	static Type parse(char value) {
		if ('/' == value) {
			return Type.SPARE
		} else if ('X' == value) {
			return Type.STRIKE
		} else if ('-' == value) {
			return Type.MISS
		} else {
			return Type.NUMBER
		}
	}

}

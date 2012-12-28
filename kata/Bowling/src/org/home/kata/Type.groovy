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
			throw new IllegalStateException("Numberical value for a type which does not need it: "
				+ this)
		}
	}
	
	boolean canGetNumerical() {
		return this != SPARE
	}
	
	private static Type parse(char value) {
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

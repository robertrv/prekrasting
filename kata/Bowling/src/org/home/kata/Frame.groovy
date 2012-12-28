package org.home.kata

class Frame {
	private int firstShot
	private int secondShot
	private int bonus
	private Type type

	public Frame(char firstShot) {
		type = Type.parse(firstShot)
		this.firstShot = type.numericalValue(firstShot)
	}
	
	public int calculateTotal() {
		return firstShot + secondShot + bonus
	}
	
	public int parse(String input, int index) {
		if (needASecondShot()) {
			index ++;
		}
		return index;
	}

	private boolean needASecondShot() {
		return type != Type.STRIKE
	}
	
	private void addSecondShot(char second) {
		Type type = Type.parse(second)
		if (type == Type.SPARE) {
			secondShot = 10 - firstShot
		} else {
			secondShot = type.numericalValue(second)
		}
	}
	
}

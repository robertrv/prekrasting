package org.home.kata

class Frame {
	private int firstShot
	private int secondShot
	private int bonus
	private Type type

	Frame(char firstShot) {
		setType(firstShot)
		this.firstShot = type.numericalValue(firstShot)
	}
	
	Frame(char current, Character secondChar) {
		this(current)
		if (secondChar != null) {
			setType(secondChar)
			addSecondShot(secondChar)
		}
	}

	private void setType(char c) {
		type = Type.parse(c)
		bonus = 0
	}
	
	public int calculateTotal() {
		return firstShot + secondShot + bonus
	}
	
	public int parse(String input, int index) {
		if (type.needASecondShot()) {
			char second = input.charAt(index)
			setType(second)
			
			addSecondShot(second)
			return index+1;
		}
		return index;
	}
	
	void addBonus(int bonus){
		this.bonus += bonus;
	}
	
	int getFirstShot() {
		return firstShot
	}
	
	int numberBonusDeserved() {
		int bonus = 0
		if (type == Type.SPARE) {
			bonus = 1
		} else if (type == Type.STRIKE) {
			bonus = 2
		}
		return bonus
	}
	
	Type getType() {
		return type
	}
	
	private void addSecondShot(char second) {
		if (type == Type.SPARE) {
			secondShot = 10 - firstShot
		} else {
			secondShot = type.numericalValue(second)
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[type:").append(type)
		sb.append(",first:").append(firstShot)
		if (type.needASecondShot()) {
			sb.append(",second:").append(secondShot)
		}
		sb.append(", total: ").append(calculateTotal())
		
		sb.append("]")
		return sb.toString();
	}
}

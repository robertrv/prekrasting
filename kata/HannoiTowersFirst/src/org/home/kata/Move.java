package org.home.kata;

/**
 * Represents a movement in the hannoi tower
 */
public class Move {

	enum Column {
		SOURCE, MIDDLE, TARGET;
	}

	private int discNumber;
	private Column origin;
	private Column destination;

	public Move(int discNumber, Column origin, Column dest) {
		super();
		this.discNumber = discNumber;
		this.origin = origin;
		this.destination = dest;
	}

	public int getDiscNumber() {
		return discNumber;
	}

	public Column getOrigin() {
		return origin;
	}

	public Column getDest() {
		return destination;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[#").append(discNumber).append(". ").append(origin.name());
		builder.append("-->");
		builder.append(destination);
		return builder.toString();
	}
}

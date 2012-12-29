package org.home.kata;

import java.util.ArrayList;

/**
 * An structure which takes care of the list of frames but also knows 
 * how to calculate the bonuses.
 * 
 * @author robertramirezvique
 *
 */
public class FrameList extends ArrayList<Frame>{
	
	private static final long serialVersionUID = 1L;

	public FrameList(int initialCapacity) {
		super(initialCapacity);
	}
	
	public void parseInput(String input) {
		for (int i = 0; i < input.length(); ) {
			i = parseFrame(input, i);
		}
	}
	
	private int parseFrame(String input, int i) {
		char current = input.charAt(i);
		Frame frame = new Frame(current);
		int lastPosition = frame.parse(input, i+1);
		
		sumBonusesFromFuture(frame, input, lastPosition);

		add(frame);
		
		lastPosition = manageLastFrame(frame, input, lastPosition);
		
		return lastPosition;
	}

	private int manageLastFrame(Frame frame, String input, int i) {
		if (isLastAndBonused(frame, input.length(), i)) {
			return input.length();
		}
		return i;
	}
	
	private boolean isLastAndBonused(Frame frame, int size, int i) {
		if (frame.getType() == Type.STRIKE){
			return i+2 == size;
		} else if (frame.getType() == Type.SPARE) {
			return i+1 == size;
		} else {
			return false;
		}
	}


	private void sumBonusesFromFuture(Frame current, String input, int i) {
		int deserved = current.numberBonusDeserved();
		int index = i;
		int lastBonus = 0;
		while (deserved-- > 0 && index<input.length()) {
			char bonusChar = input.charAt(index);
			Type bonusType = Type.parse(bonusChar);
			if (bonusType == Type.SPARE) {
				lastBonus = 10 - lastBonus;
			} else {
				lastBonus = bonusType.numericalValue(bonusChar);
			}
			current.addBonus(lastBonus);
			
			index++;
		}
	}
	
}

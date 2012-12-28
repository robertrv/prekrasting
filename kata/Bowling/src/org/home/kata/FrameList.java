package org.home.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * An structure which takes care of the list of frames but also knows 
 * how to calculate the bonuses.
 * 
 * @author robertramirezvique
 *
 */
public class FrameList extends ArrayList<Frame>{
	
	
	public FrameList(int initialCapacity) {
		super(initialCapacity);
	}
	
	public void parseInput(String input) {
		for (int i = 0; i < input.length(); i++) {
			i = parseFrame(input, i);
		}
	}
	
	private int parseFrame(String input, int i) {
		char current = input.charAt(i);
		Frame frame = new Frame(current);
		add(frame);
		int lastPosition = frame.parse(input, i+1);
		// Now is time to find about bonuses, so should go to previous elements
		sumBonuses(frame);
		
		// and finally treat the case of last frame
		return lastPosition;
	}

	private void sumBonuses(Frame frame) {
		// TODO Auto-generated method stub
		
	}
	
}

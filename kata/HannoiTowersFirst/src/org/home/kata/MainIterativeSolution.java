package org.home.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.home.kata.Move.Column;

/**
 * Implementation of @see http://www.solveet.com/exercises/Torres-de-Hannoi/72
 * 
 * This class represents the In the state of the class we will have three
 * stacks,
 * 
 * @author robert [at] gmail.com
 * 
 * Solution based on @see 
 * 		http://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i#Soluci.C3.B3n_simple
 * 
 */
public class MainIterativeSolution {

	private static final int SMALLEST_DISK_VALUE = 0;
	private Logger logger = Logger.getLogger(MainIterativeSolution.class.getName());
	private DiskStack source;
	private DiskStack middle;
	private DiskStack target;
	List<Move> movements = new ArrayList<Move>();

	public MainIterativeSolution() {
		source = new DiskStack(Column.SOURCE);
		middle = new DiskStack(Column.MIDDLE);
		target = new DiskStack(Column.TARGET);
	}

	public List<Move> calculateOrder(int n) {
		logger.log(Level.INFO, "Starting. ");
		if (n <= 0) {
			return Collections.emptyList();
		}
		initSource(n-1);
		logger.log(Level.INFO, "Initialized: {0} ", this);
		
		boolean haveEvenDisks = (n%2 == 0);
		int step = 0;
		while (!hasFinished()) {
			logger.log(Level.INFO, "Current state: {0}", this);
			
			if (step++ % 2 == 0) { // even
				// Move smallest
				if (haveEvenDisks) { // Move to the right
					moveSmallestToLeft();
				} else { // Move to the left
					moveSmallestToRight();
				}
			} else { // odd
				// Move second smallest
				tryMoveNonSmallest();
			}
		}
		return movements;
	}
	
	private void tryMoveNonSmallest() {
		DiskStack smallest = findSmallest();
		DiskStack first;
		DiskStack second;
		
		if (smallest == source) {
			first = middle;
			second = target;
		} else if (smallest == middle){
			first = source;
			second = target;			
		} else {
			first = source;
			second = middle;			
		}
		
		if (first.isEmpty() && second.isEmpty()) {
			// We don't have to move now.
			return;
		}
		
		if (first.isEmpty()) {
			move(second, first);
		} else if (second.isEmpty()) {
			move(first, second);
		} else {
			if (first.top() < second.top()) {
				move(first, second);
			} else {
				move(second, first);
			}			
		}
		
	}

	private void moveSmallestToLeft() {
		DiskStack smallestDisk = findSmallest();
		switch (smallestDisk.getColumn()) {
			case SOURCE:
				move(smallestDisk, target);
				break;
			case MIDDLE:
				move(smallestDisk, source);
				break;
			case TARGET:
			default:
				move(smallestDisk, middle);
				break;
		}
	}

	private void moveSmallestToRight() {
		DiskStack smallestDisk = findSmallest();
		switch (smallestDisk.getColumn()) {
			case SOURCE:
				move(smallestDisk, middle);
				break;
			case MIDDLE:
				move(smallestDisk, target);
				break;
			case TARGET:
			default:
				move(smallestDisk, source);
				break;
		}
	}

	private DiskStack findSmallest() {
		if (containsTheSmallest(source)) {
			return source;
		} else if (containsTheSmallest(middle)) {
			return middle;
		} else if (containsTheSmallest(target)){
			return target;
		} else {
			throw new IllegalStateException("Smallest disk has gone away!");
		}
	}

	private boolean containsTheSmallest(DiskStack stack) {
		return stack.top() == SMALLEST_DISK_VALUE;
	}

	private void secureMove(DiskStack stackSource, DiskStack stackTarget) {
		if (!stackSource.isEmpty()) {
			move(stackSource, stackTarget);
		}
	}
	
	private void move(DiskStack source, DiskStack target) {
		logger.log(Level.INFO, "asked to move from {0} to {1}", new Object[] {
				source.getColumn(), target.getColumn() });
		Integer disc = source.pop();
		target.push(disc);
		Move move = new Move(disc, source.getColumn(),
				target.getColumn());
		logger.log(Level.INFO, "Movement: {0}. new State: {1}", new Object[] {
				move, this });
		assertValidState();
		movements.add(move);
	}

	public boolean hasFinished() {
		assertValidState();
		return source.isEmpty() && middle.isEmpty() && !target.isEmpty();
	}

	private void assertValidState() {
		if (!(source.isAscending() && middle.isAscending() && target
				.isAscending())) {
			logger.log(Level.INFO, "state: {0}", this);
			throw new IllegalStateException(
					"Some of the disk stacks are incorrect!");
		}
	}

	private void initSource(int n) {
		for (int i = n; i >= 0; i--) {
			source.push(i);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("source:");
		sb.append(source);
		sb.append(",");

		sb.append("middle:");
		sb.append(middle);
		sb.append(",");

		sb.append("target:");
		sb.append(target);
		sb.append(",");

		sb.append("]");
		return sb.toString();
	}

	class DiskStack extends ArrayList<Integer> {

		private static final long serialVersionUID = 1L;
		private Column column;

		public DiskStack(Column source) {
			this.column = source;
		}

		public Column getColumn() {
			return column;
		}

		public Integer pop() {
			Integer e = get(size() - 1);
			remove(size() - 1);
			return e;
		}
		
		public Integer top() {
			if (isEmpty()) {
				return -1;
			}
			return get(size() - 1);
		}

		public void push(Integer e) {
			add(e);
		}

		public boolean isAscending() {
			if (size() <= 1) {
				return true;
			}
			for (int i = 1; i < size(); i++) {
				if (get(i - 1) <= get(i)) {
					return false;
				}
			}
			return true;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (Integer value : this) {
				sb.append(value);
				sb.append(" ");
			}
			return sb.toString();
		}
	}
}

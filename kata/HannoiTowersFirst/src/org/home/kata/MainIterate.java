package org.home.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
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
 */
public class MainIterate {

	private Logger logger = Logger.getLogger(MainIterate.class.getName());
	private DiskStack source;
	private DiskStack middle;
	private DiskStack target;

	public MainIterate() {
		source = new DiskStack(Column.SOURCE);
		middle = new DiskStack(Column.MIDDLE);
		target = new DiskStack(Column.TARGET);
	}

	public List<Move> calculateOrder(int n) {

		logger.log(Level.INFO, "Starting. ");
		if (n <= 0) {
			return Collections.emptyList();
		}
		initSource(n);
		logger.log(Level.INFO, "Initialized: {0} ", this);
		List<Move> movements = new ArrayList<Move>();
		while (!hasFinished()) {
			assertValidState();
			logger.log(Level.INFO, "Current state: {0}", this);
			if (source.size() < 1) {
				throw new IllegalStateException(
						"We should never arrive to this situation! Or we do?");
			}
			
			logger.log(Level.INFO, "Going to move smallest: {0} ", this);
			movements.add(move(source,target));

			int numberMoved = 0;
			while (numberMoved < 2 && source.size() > 0) {
				movements.add(move(source, middle));
				numberMoved++;
			}
			
			logger.log(Level.INFO, "Going to move back smallest: {0} ", this);
			movements.add(move(target, source));
			
			logger.log(Level.INFO, "Prior to remove: {0} {1}", new Object[] {
					this, numberMoved });
			while (numberMoved-- > 0) {
				logger.log(Level.INFO, "In the middle: {0}, number moved: {1}",
						new Object[] { this, numberMoved });
				movements.add(move(middle, target));
			}
			
			if (source.size() == 1) {
				movements.add(move(source, target));				
			}
			

		}
		return Collections.emptyList();
	}

	private Move move(DiskStack stackSource, DiskStack stackTarget) {
		Integer disc = stackSource.pop();
		stackTarget.push(disc);
		Move move = new Move(disc, stackSource.getColumn(), stackTarget.getColumn());
		logger.log(Level.FINE, "Movement: {0}", move);
		return move;
	}

	public boolean hasFinished() {
		assertValidState();
		return source.isEmpty() && middle.isEmpty() && !target.isEmpty();
	}

	private void assertValidState() {
		assert source.isAscending() && middle.isAscending()
				&& target.isAscending();
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

		public void push(Integer e) {
			add(e);
		}

		public boolean isAscending() {
			if (size() == 1) {
				return true;
			}
			for (int i = 1; i < size(); i++) {
				if (get(i - 1) >= get(i)) {
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

package org.home.kata;

import org.home.kata.Move.Column;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An iterative solution
 * 
 * @author robert [at] gmail.com
 * 
 * Solution based on @see 
 * 		http://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i#Soluci.C3.B3n_simple
 * 
 */
public class MainRecursiveSolution extends MainIterativeSolution {

	private Logger logger = Logger.getLogger(MainRecursiveSolution.class.getName());

	public MainRecursiveSolution() {
        super();
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

        return null;
	}

}

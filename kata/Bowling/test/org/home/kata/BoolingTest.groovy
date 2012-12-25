package org.home.kata;

import static org.junit.Assert.*

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters


/**
 * @author robertrv
 */
@RunWith(Parameterized)
class BoolingTest {
	
	Bowling iut
	def result
	
	BoolingTest(String score, int result) {
		this.result = result
		this.iut = new Bowling(score)
	}
	
	@Parameters
	static Collection<Object[]> data() {
		def data =[["",0],
				["0",0],
				["XXXXXXXXXXXX", 300],
				["339-9-9-9-9-9-9-9-9-",90],
				["9-9-9-9-9-9-9-9-9-9-",90],
				["5/5/5/5/5/5/5/5/5/5/5",150]]
		return data.collect{ it as Object[]}
	}
	
	@Test
	void calculate() {
		println "rolls: ${iut.score}, expected amount in points: ${result}"
		assertEquals("rolls: ${iut.score}", result, iut.calculate())
	}

}

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
class BowlingTest {

	Bowling iut
	def expectedResult

	BowlingTest(String score, int result) {
		this.expectedResult = result
		this.iut = new Bowling(score)
	}

	@Parameters
	static Collection<Object[]> data() {
		def data =[
			["", 0],
			["--", 0],
			["X33-9", 16+6+9],
			["1/33-9",13+6+9], // this is simply an spare!
			["339-9-9-9-9-9-9-9-9-", 87],
			["9-9-9-9-9-9-9-9-9-9-", 90],
			["XXXXXXXXXXXX", 300],
			["5/5/5/5/5/5/5/5/5/5/5",150],
			// corner cases
			["12X2/", 3+20],
			["12X2/3", 3+20+13],
			["12XX2", 3+22],
			["12XXX22", 3+30+22+14],
		]
		return data.collect{ it as Object[]}
	}

	@Test
	void calculate() {
		def actualResult = iut.calculate()
		println "rolls: ${iut.score}, expected amount in points: ${expectedResult}, actual: ${actualResult}"
		assertEquals("rolls: ${iut.score}", expectedResult, actualResult)
	}

}

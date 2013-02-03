package org.home.kata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: robert
 * Date: 2/3/13
 * A simple test case for the Master Mind game.
 */
@RunWith(Parameterized.class)
public class MasterMindExecutorTest {

    private String currentTry;
    private String result;
    private String solution;

    public MasterMindExecutorTest(String currentTry, String result, String solution) {
        this.currentTry = currentTry;
        this.result = result;
        this.solution = solution;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                new String[]{"YNYI", "X*", "RANI"},
                new String[]{"RMVI", "XX", "RANI"},
                new String[]{"RRVN", "X**", "NRRI"},
                new String[]{"RMMM", "XXXX", "RMMM"},
                new String[]{"RMMM", "X", "RNNN"},
                new String[]{"RRRM", "X", "MMMM"},
                new String[]{"RMRM", "XX", "MMMM"},
                new String[]{"AAAA", "", "MMMM"},

                new String[]{"RAAA", "*", "MMMR"},
                new String[]{"RAMV", "**", "MVNM"},
                new String[]{"RAMV", "***", "VRAN"},
                new String[]{"RAMV", "****", "VRAM"},

                new String[]{"RMMM", "XX", "RMNN"},
                new String[]{"RMMM", "XXX", "RMNM"},
                new String[]{"RAVM", "XX**", "RAMV"},
                new String[]{"RAVM", "XX*", "RAMA"},
                new String[]{"RMVM", "X*", "RAMA"},

        });
    }

    @Test
    public void testCheckCode() throws Exception {
        MasterMindExecutor executor = new MasterMindExecutor(solution);

        assertEquals("Testing " + this, result, executor.checkCode(currentTry));
    }


    @Override
    public String toString() {
        return "MasterMindExecutorTest{" +
                "currentTry='" + currentTry + '\'' +
                ", result='" + result + '\'' +
                ", solution='" + solution + '\'' +
                '}';
    }
}

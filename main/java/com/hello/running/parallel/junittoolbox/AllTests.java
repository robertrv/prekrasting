package com.hello.running.parallel.junittoolbox;

import com.googlecode.junittoolbox.ParallelSuite;
import com.googlecode.junittoolbox.SuiteClasses;
import org.junit.runner.RunWith;

@RunWith(ParallelSuite.class)
@SuiteClasses("tests/*.class")
public class AllTests {
}

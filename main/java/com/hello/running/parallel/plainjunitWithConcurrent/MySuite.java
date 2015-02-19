package com.hello.running.parallel.plainjunitWithConcurrent;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({ATest.class, ATest2.class, ATest3.class, ATest4.class})
@Concurrent
public class MySuite {
}

package com.hello.running.parallel.plainjunit;

import org.junit.runner.RunWith;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({ParallelTest1.class, ParallelTest2.class})
public class OurSuite {

}

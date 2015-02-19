package com.hello.running.parallel.junittoolbox;

import com.googlecode.junittoolbox.IncludeCategories;
import com.googlecode.junittoolbox.ParallelSuite;
import com.googlecode.junittoolbox.SuiteClasses;
import com.hello.running.parallel.junittoolbox.categories.Canary;
import org.junit.runner.RunWith;

@RunWith(ParallelSuite.class)
@SuiteClasses("tests/*.class")
@IncludeCategories(Canary.class)
public class CanaryTests {
}

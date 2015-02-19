package com.hello.running.parallel.junittoolbox;

import com.googlecode.junittoolbox.IncludeCategories;
import com.googlecode.junittoolbox.ParallelSuite;
import com.googlecode.junittoolbox.SuiteClasses;
import com.hello.running.parallel.junittoolbox.categories.Canary;
import com.hello.running.parallel.junittoolbox.tests.T1;
import com.hello.running.parallel.junittoolbox.tests.T2;
import com.hello.running.parallel.junittoolbox.tests.T3;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class Suites {
    @RunWith(ParallelSuite.class)
    @SuiteClasses("tests/*.class")
    public static class AllTests {}


    @RunWith(ParallelSuite.class)
    @Suite.SuiteClasses({ T1.class, T2.class, T3.class })
    public static class AllByClass {}


    @RunWith(ParallelSuite.class)
    //@Suite.SuiteClasses({ T1.class, T2.class, T3.class })
    @IncludeCategories({Canary.class})
    public static class Canaries extends AllByClass {}
}

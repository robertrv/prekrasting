package com.hello.running.parallel.junittoolbox.tests;

import com.hello.running.parallel.junittoolbox.categories.Canary;
import com.hello.running.parallel.junittoolbox.categories.Category1;
import org.junit.experimental.categories.Category;


@Category({ Category1.class, Canary.class })
public class T1 extends Base {
}

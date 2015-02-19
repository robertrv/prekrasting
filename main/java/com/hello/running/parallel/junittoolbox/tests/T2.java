package com.hello.running.parallel.junittoolbox.tests;

import org.junit.Assert;

public class T2 extends Base {

    @Override
    public void b() throws Exception {
        super.b();
        Assert.fail("Override fail");
    }
}

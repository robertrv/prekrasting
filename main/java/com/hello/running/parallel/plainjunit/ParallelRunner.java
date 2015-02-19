package com.hello.running.parallel.plainjunit;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.RunnerScheduler;

public class ParallelRunner extends BlockJUnit4ClassRunner {

    private static class ThreadPoolScheduler implements RunnerScheduler {
        private final ExecutorService fService = Executors.newCachedThreadPool();

        public void schedule(Runnable childStatement) {
            fService.submit(childStatement);
        }

        public void finished() {
            try {
                fService.shutdown();
                fService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public ParallelRunner(Class<?> klass) throws Throwable {
        super(klass);
        setScheduler(new ThreadPoolScheduler());
    }


}

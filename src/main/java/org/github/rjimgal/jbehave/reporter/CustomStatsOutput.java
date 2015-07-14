package org.github.rjimgal.jbehave.reporter;

import java.io.OutputStream;

import org.jbehave.core.reporters.PostStoryStatisticsCollector;

public class CustomStatsOutput extends PostStoryStatisticsCollector {

    private long statsCreatedForThread = -1;

    public CustomStatsOutput(final OutputStream output) {
        super(output);
        statsCreatedForThread = Thread.currentThread().getId();
    }

    @Override
    public void beforeScenario(String title) {
        if (Thread.currentThread().getId() != statsCreatedForThread) {
            System.err.println(String.format("***** Stats was created for Thread ID %s, but it is being executed from Thread ID %s",
                    statsCreatedForThread, Thread.currentThread().getId()));

            throw new RuntimeException("Wrong Thread IDs!");
        }
        
        super.beforeScenario(title);
    }
}

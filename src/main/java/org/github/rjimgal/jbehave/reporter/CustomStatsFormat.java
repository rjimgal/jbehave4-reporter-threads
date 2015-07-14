package org.github.rjimgal.jbehave.reporter;

import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class CustomStatsFormat extends Format {

    public CustomStatsFormat() {
        super("STATS");
    }

    @Override
    public StoryReporter createStoryReporter(FilePrintStreamFactory factory, StoryReporterBuilder storyReporterBuilder) {
        storyReporterBuilder = storyReporterBuilder.withMultiThreading(true);

        factory.useConfiguration(storyReporterBuilder.fileConfiguration("stats"));
        return new CustomStatsOutput(factory.createPrintStream());
    }

}

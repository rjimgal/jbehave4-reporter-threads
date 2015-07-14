package org.github.rjimgal.jbehave.reporter;

import org.jbehave.core.reporters.StoryReporterBuilder;

public class CustomStoryReporterBuilder extends StoryReporterBuilder {

    public CustomStoryReporterBuilder() {
        super.withDefaultFormats().withFormats(new CustomStatsFormat()).withFailureTrace(true);
    }

}

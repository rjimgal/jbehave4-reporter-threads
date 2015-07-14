package org.github.rjimgal.jbehave.tests;

import java.util.List;

import org.github.rjimgal.jbehave.reporter.CustomStoryReporterBuilder;
import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class, ignoreFailureInStories = false, ignoreFailureInView = false)
// This CustomStoryReporterBuilder will create a CustomStatsFormat showing thread's issue.
@Configure(storyReporterBuilder = CustomStoryReporterBuilder.class)
@UsingSpring(resources = { "org.github.rjimgal.jbehave.tests.TestConfig" })
public final class TestRunner extends InjectableEmbedder {

    @Test
    public void run() {
        // Set Thread count to 2.
        injectedEmbedder().embedderControls().useThreads(10);

        final List<String> stories =
                new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), "stories/*.story",
                        " ");

        injectedEmbedder().runStoriesAsPaths(stories);
    }
    
}
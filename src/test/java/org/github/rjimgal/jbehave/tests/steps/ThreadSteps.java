package org.github.rjimgal.jbehave.tests.steps;

import org.jbehave.core.annotations.Given;
import org.springframework.stereotype.Component;

@Component
public class ThreadSteps {

    @Given("something")
    public void something() throws Exception {
        System.out.println(String.format("Something is being executed in Thread ID %s", Thread.currentThread().getId()));
    }

}

# jbehave4-reporter-threads

This maven project reproduces PerformableTree$RunContext StoryReporter thread issue in JBehave 4.x branch

## Run using JBehave 4.0.1

Just execute `mvn clean install`

Output will look like:

```
***** Stats was created for Thread ID 13, but it is being executed from Thread ID 10  
***** Stats was created for Thread ID 13, but it is being executed from Thread ID 12
***** Stats was created for Thread ID 13, but it is being executed from Thread ID 9
***** Stats was created for Thread ID 13, but it is being executed from Thread ID 11
```

Maven build may fail depending on your setup.

## Run using JBehave 3

Just execute `mvn clean install -Pjbehave3`

Maven build will success this time.

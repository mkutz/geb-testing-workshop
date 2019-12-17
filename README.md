# Geb Testing Workshop [![Actions Status](https://github.com/mkutz/geb-testing-workshop/workflows/CI/badge.svg)](https://github.com/mkutz/geb-testing-workshop/actions)

In this workshop we'll introduce the participants to the [Geb framework](https://gebish.org) and how to use it for real groovy browser automation.

We will make use of the [Spock framework](http://spockframework.org) for the tests but won't go into much detail on that.

## TODO

- [ ] Setup: Gradle, GebConfig.groovy @erdi
- [X] CfP Greach @mkutz
- [X] Application under test @mkutz/@erdi → https://react-redux.realworld.io/
- [X] Setup repo @mkutz
- [ ] Application under test startup/integration (separate Gradle project/module/task) @erdi
- [ ] README.md with tasks, manual links @mkutz

## Setup

- How does this project work (see [GebConfig.groovy](src/test/resources/GebConfig.groovy), [build.gradle](build.gradle))

## Basics

We are going to specify a [RealWorld example](https://github.com/gothinkster/realworld).

- [ ] Open [BasicSpec] and implement the first feature.
      First use the `go` method to navigate https://react-redux.realworld.io/.
      Then use the `$` the verify there is a `div` with class `feed-toggle`.
- [ ] In the second feature, check if the only `h1` on the page has the `text` "Sign Up".
- [ ] In the third feature the `h1`'s `text` should be "Sign In".
- [ ] Since we don't want to re-type that URL all the time, let's define it as `baseUrl` for the suite.
      Open [GebConfig.groovy] and change the baseUrl.
      Update the features to use relative URLs and rely on the `baseUrl`.

## Page Objects

So now we already visited three different pages and implemented checks to verify we are at these pages.
Next we would want to interact with these pages, which would lead to a lot of duplicate code.

- [ ] Create the page objects [HomePage], [RegisterPage] and [LoginPage].
      Set the page `url`s and specify an `at` check on each of them.
      Refactor your features to use `to` instead of `go` and `at` instead of `$`.
- [ ] Now open [RegistrationSpec] and implement the first feature.
      Define each element as `content` of the [RegisterPage].
      We should stay on the [RegisterPage].
- [ ] Implement the second feature.
      Consider yourself logged in, when there is a link displayed with `href` "#editor".
      This won't work, add a `@PendingFeature` annotation.

## Waiting

- different definitions in content `wait: true`, `wait: 5`, `wait: "long"`
- using `waitFor` in methods

## Modules

- build-in `geb.Module`s
- move repeating content to `geb.Module`s
- move complex content to `geb.Module`s

## Configuration

- setting a `baseUrl` via `GebConfig.groovy` or system property
- reporting, the `GebReportingSpec`
- defining `environments`
- `wait` presets

## More…

- avoid the `StaleElementException`
- combination with Testcontainers


[GebConfig.groovy]: <src/test/resources/GebConfig.groovy>
[BasicSpec]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/BasicSpec.groovy>
[RegistrationSpec]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/RegistrationSpec.groovy>
[HomePage]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/HomePage.groovy>
[RegisterPage]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/RegisterPage.groovy>
[LoginPage]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/LoginPage.groovy>
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
      Then use the `$` the verify there is a `div` with class `home-page`.
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
      Refactor your features to use `to` instead of `go` and just expect this to work.
      Geb's `to` automatically verifies the success of the navigation by calling `at` and returns the page object.

## Waiting

Especially on single page applications, some content is loaded dynamically.
This means that they will show up eventually, but we cannot tell when.
When using such a page as a human, you might not even notice, but Geb will try to find the element _immediately_ and will fail if it is not there, yet.

- [ ] Now open [RegistrationSpec] and implement the first feature.
      Check for an error message and verify it starts with "username can't be blank".
      Since the error message is loaded dynamically, you will need to wait for it in some way.
- [ ] Implement the second feature if [RegistrationSpec].
      Define each element as `content` of the [RegisterPage].
      Consider the test to be successful, when you end on the [HomePage].
      Again, you will need to use some kind of waiting.

## Modules

Sometimes web applications' pages consist of several interesting components.
E.g. the page's header or navigation or a form with multiple inputs.
We refer to these components in natural language.
E.g. "Fill the registration form."
Geb's modules are a way to achieve that.

- [ ] Revisit the [RegisterPage] and move the content elements to a new [RegisterFormModule].
      Add a `register` method, which takes username, password and email address as parameters.
      It should add the values to the inputs and submit the form.

Modules are not only great for complex content, but also for repeating content.

- [ ] Now let's implement the second feature of the [FeedSpec].
      Note that the first feature uses an extra `waitFor` to make sure all articles are loaded.
      Create a [ArticlePreviewModule] with a method returning a LocalDate.

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
[FeedSpec]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/FeedSpec.groovy>
[RegisterFormModule]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/RegisterFormModule.groovy>
[FeedSpec]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/FeedSpec.groovy>
[ArticlePreviewModule]: <src/test/groovy/io/github/mkutz/gebtestingworkshop/ArticlePreviewModule.groovy>
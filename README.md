# Geb Testing Workshop [![Actions Status](https://github.com/mkutz/geb-testing-workshop/workflows/CI/badge.svg)](https://github.com/mkutz/geb-testing-workshop/actions)

In this workshop we'll introduce the participants to the [Geb framework](https://gebish.org) and how to use it for real groovy browser automation.

We will make use of the [Spock framework](http://spockframework.org) for the tests but won't go into much detail on that.

## Application under test

In this workshop we will be using an instance of [RealWorld example app](https://github.com/gothinkster/realworld) which is dockerised based on a [docker-compose.yaml] file.
We will be using the React + MobX version of the frontend which is [available on docker hub](https://hub.docker.com/repository/docker/gebish/react-mobx-realworld-example-app) based on [this clone repository](https://github.com/erdi/react-mobx-realworld-example-app).
For the backend, we will be using the SpringBoot version which is also [available on docker hub](https://hub.docker.com/repository/docker/gebish/spring-boot-realworld-example-app) and it's based on [this clone repository](https://github.com/erdi/spring-boot-realworld-example-app).

## Setup

- To import the project into IntelliJ simply run `./gradlew openIdea` (or `gradlew.bat openIdea` if you're using Windows) in the root of the repository
- To start up the application run `docker-compose up` - the application will be available on localhost at port 3000.
- How does this project work (see [GebConfig.groovy], [build.gradle])

## Basics

- [ ] Open [`BasicSpec`] and implement the first feature.
      First use the `go()` method to navigate http://localhost:3000/.
      Then use the `$()` method the verify there is a `div` with class `home-page`.
- [ ] In the second feature, check if the only `h1` on the page has the `text` "Sign Up".
- [ ] In the third feature the `h1`'s `text` should be "Sign In".
- [ ] Since we don't want to re-type that URL all the time, let's define it as `baseUrl` for the suite.
      Open [GebConfig.groovy] and set the `baseUrl` outside of the `environments` block.
      Implement the three outstanding features by using relative URLs and rely on `baseUrl`.

## Page Objects

So now we already visited three different pages and implemented checks to verify we are at these pages.
Next we would want to interact with these pages, which would lead to a lot of duplicate code.

- [ ] Create `HomePage`, `RegistrationPage` and `LoginPage` classes all extending `geb.Page` and located in `org.gebish.geb.workshop.objective02pages` package.
      Set the page `url`s and specify an `at` checker on each of them.
      Implement features in [`AtCheckerSpec`] by using `to()`.
      Use the `at()` method in your assertions even though `to()` automatically verifies the success of the navigation by calling `at()`.
      Also note that `to()` returns an instance of the page object class passed to it.

## Waiting

Especially on single page applications, some content is loaded dynamically.
This means that they will show up eventually, but we cannot tell when.
When using such a page as a human, you might not even notice, but Geb will try to find the element _immediately_ and will fail if it is not there, yet.

- [ ] Copy the `RegistrationPage` from `objective02pages` package to `objective03waiting` package.
      Implement the feature in [`WaitingSpec`].
      Go to `RegistrationPage` fill out the email and password fields and submit the form.
      Check for an error message and verify it starts with "username can't be blank".
      Since the error message is loaded dynamically, you will need to wait for it to appear.

## Content

So far we've been using inline css selectors in specs.
This can be very repetitive the more you interact with content in tests and that's why Geb has a concept of content definitions to remove the need for such duplication.
It also means that if the selectors change for any reason then they have to be changed only in one place and not for each tests in which they are used. 

- [ ] Copy the `HomePage` and `RegistrationPage` from `objective02pages` package to `objective04content` package.
      Introduce a content definition for the selector used in `HomePage`'s `at` checker. 
      Introduce content definitions for username, email and password form elements, the submit button and the list of error messages in `RegistrationPage` as well as a content definition for the selector used in `at` checker.
      The implementation of the first feature in [`ContentSpec`] should be very similar to the implementation of the feature from the previous objective but it should use the newly introduced content definitions.
      Use the password, username and email values already provided in the spec.
      For the second feature, go to `RegistrationPage`, fill out the email and password as well as the username and check that you end up at `HomePage` after submitting the form.

## Modules

Sometimes web applications' pages consist of several interesting components.
E.g. the page's header or navigation or a form with multiple inputs.
We refer to these components in natural language.
E.g. "Fill the registration form."
Geb's modules are a way to achieve that.
Modules are not only great for complex content, but also for repeating content.

- [ ] Copy the `HomePage` from `objective04content` package to `objective05modules` package.
      Add an `ArticlePreview` class extending `geb.Module` with a content definition for author username.
      Add a content definition to `HomePage` for a list of article previews using `Navigator`'s `moduleList()` method.
      Implement the feature in [`ModulesSpec`] by going to `HomePage`, grouping previews by author and then asserting article counts for each of the authors.
      There is already some code in `ModulesSpec` which deals with bootstrapping article data for you.

## Page Methods

Pages and modules are not only useful for abstracting selectors out into content definitions.
It's also useful to declare methods on pages and modules which contain common actions.
Such methods can help to avoid duplication and make tests more readable.

- [ ] Copy `LoginPage` from `objective02pages`package and `HomePage` as well as `ArticlePreview` module from `objective05modules` package to `objective06pagemethods` package.
      Add a `login()` method to `LoginPage` taking a username and password which fills out the login form and submits it.
      Use that new method in [`PageMethodsSpec`] to login at `LoginPage` and verify that you end up at `HomePage` afterwards.
      Code creating a user is already provided in the spec.

## Advanced Waiting

When dealing with asynchronous applications waiting for asynchronous events to complete is very important otherwise the tests will be flakey.
A useful technique is to wrap waiting in methods of pages and modules.
Waiting should be added immediately after executing an action triggering an asynchronous event.
This makes tests appear as if they were synchronous even when they are not.
Another benefit is that all team members do not have to exactly understand which parts are asynchronous as long as they use such methods.

- [] Copy `LoginPage`, `HomePage` and `ArticlePreview` from `objective06pagemethods` package to `objective07advancedwaiting` package.
     Add a content definition to `HomePage` selecting the div with "No articles are here... yet." text which appears when there are no articles.
     Change the at checker to check if either some article previews or no article available message has been rendered.
     This will mean that the at checker for `HomePage` succeeds only after the page is fully loaded even though article previews are resolved asynchronously.
     Add a check at the end of the `login()` method in `LoginPage` to ensure that we are at `HomePage` - that way calls to `login()` will finish only after the `HomePage` has been rendered even though it happens asynchronously.
     Actions in the first feature of [`AdvancedWaitingSpec`] should be the same as in [`ModulesSpec`] but there should not be any explicit waiting in the spec.
     Implementation of the second feature should be the same as the one in [`PageMethodsSpec`].

## Configuration

- setting a `baseUrl` via `GebConfig.groovy` or system property
- reporting, the `GebReportingSpec`
- defining `environments`
- `wait` presets

## More…

- avoid the `StaleElementException`
- combination with Testcontainers


[docker-compose.yaml]: <docker-compose.yml>
[GebConfig.groovy]: <src/test/groovy/GebConfig.groovy>
[build.gradle]: <build.gradle>
[`BasicSpec`]: <src/test/groovy/org/gebish/geb/workshop/objective01basicnavigation/BasicSpec.groovy>
[`AtCheckerSpec`]: <src/test/groovy/org/gebish/geb/workshop/objective02pages/AtCheckerSpec.groovy>
[`WaitingSpec`]: <src/test/groovy/org/gebish/geb/workshop/objective03waiting/WaitingSpec.groovy>
[`ContentSpec`]: <src/test/groovy/org/gebish/geb/workshop/objective04content/ContentSpec.groovy>
[`ModulesSpec`]: <src/test/groovy/org/gebish/geb/workshop/objective05modules/ModulesSpec.groovy>
[`PageMethodsSpec`]: <src/test/groovy/org/gebish/geb/workshop/objective06pagemethods/PageMethodsSpec.groovy>
[`AdvancedWaitingSpec`]: <src/test/groovy/org/gebish/geb/workshop/objective07advancedwaiting/AdvancedWaitingSpec.groovy>
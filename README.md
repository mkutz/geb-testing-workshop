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

## Basics

- `go` to an URL
- Different selectors `$`
- `click()`
- `text()`

## Page Objects

- go `to` a page & verify we are `at` a `geb.Page`
- defining a page's `content`
- adding methods

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
package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec
import spock.lang.PendingFeature

import static java.util.UUID.randomUUID

class RegistrationSpec extends GebSpec {

    String someUsername = randomUUID().toString()[0..19]
    String someEmail = "${randomUUID()}@michael-kutz.de".toString()
    static final String somePassword = "test1234"

    def "registration works"() {
        given:
        RegisterPage page = to RegisterPage

        when:
        page.usernameInput = someUsername
        page.emailInput = someEmail
        page.passwordInput = somePassword
        page.submitButton.click()

        then:
        at HomePage
    }

    def "username is mandatory"() {
        given:
        RegisterPage page = to RegisterPage

        when:
        page.usernameInput = ""
        page.emailInput = someEmail
        page.passwordInput = somePassword
        page.submitButton.click()

        then:
        page.errorMessages.text() ==~ /^username can't be blank.*/
    }
}

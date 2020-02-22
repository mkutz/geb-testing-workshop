package org.gebish.geb.workshop.objective04content

import static java.util.UUID.randomUUID

import geb.spock.GebSpec

class ContentSpec extends GebSpec {

    static final String password = 'test1234'

    String username = randomUUID().toString()[0..19]
    String email = "${username}@gebish.org".toString()

    def "an error appears when no username is provided upon registration"() {
        when:
        def registrationPage = to RegistrationPage

        and:
        registrationPage.email.value(email)
        registrationPage.password.value(password)

        and:
        registrationPage.submitButton.click()

        then:
        waitFor { registrationPage.errorMessages == ['username can\'t be empty'] }
    }

    def "can register a new user"() {
        when:
        def registrationPage = to RegistrationPage

        and:
        registrationPage.username.value(username)
        registrationPage.email.value(email)
        registrationPage.password.value(password)

        and:
        registrationPage.submitButton.click()

        then:
        at HomePage
    }

}

package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec

import static java.util.UUID.randomUUID

class RegistrationSpec extends GebSpec {

    String someUsername = randomUUID().toString()[0..19]
    String someEmail = "${randomUUID()}@michael-kutz.de".toString()
    static final String somePassword = "test1234"

    def "username is mandatory"() {
        given:
        RegisterPage page = to RegisterPage

        when:
        page.registerForm.register("", someEmail, somePassword)

        then:
        page.errorMessages.text().contains("username can't be blank")
    }

    def "registration works"() {
        given:
        RegisterPage page = to RegisterPage

        when:
        page.registerForm.register(someUsername, someEmail, somePassword)

        then:
        at HomePage
    }
}

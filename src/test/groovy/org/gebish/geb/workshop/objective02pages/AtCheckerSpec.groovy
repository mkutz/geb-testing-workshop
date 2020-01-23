package org.gebish.geb.workshop.objective02pages

import geb.spock.GebSpec

class AtCheckerSpec extends GebSpec {

    def "go to the home page and verify at checker"() {
        when:
        to HomePage

        then:
        at HomePage
    }

    def "go to the registration page and verify at checker"() {
        when:
        to RegistrationPage

        then:
        at RegistrationPage
    }

    def "go to the login page and verify at checker"() {
        when:
        to LoginPage

        then:
        at LoginPage
    }

}

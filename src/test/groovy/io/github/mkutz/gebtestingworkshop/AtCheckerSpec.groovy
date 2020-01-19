package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec
import io.github.mkutz.gebtestingworkshop.page.at.HomePage
import io.github.mkutz.gebtestingworkshop.page.at.LoginPage
import io.github.mkutz.gebtestingworkshop.page.at.RegistrationPage

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

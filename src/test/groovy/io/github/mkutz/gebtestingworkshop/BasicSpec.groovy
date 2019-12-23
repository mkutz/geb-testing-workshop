package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec

class BasicSpec extends GebSpec {

    def "home page is accessible"() {
        when:
        to HomePage

        then:
        at HomePage
    }

    def "register page is accessible"() {
        when:
        to RegisterPage

        then:
        at RegisterPage
    }

    def "login page is accessible"() {
        when:
        to LoginPage

        then:
        at LoginPage
    }
}

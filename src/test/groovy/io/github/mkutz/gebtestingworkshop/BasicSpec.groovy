package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec

class BasicSpec extends GebSpec {

    def "main page is accessible"() {
        when:
        go "/"

        then:
        $(".feed-toggle")
    }

    def "register page is accessible"() {
        when:
        go "/#/register"

        then:
        $("h1").text() == "Sign Up"
    }

    def "login page is accessible"() {
        when:
        go "/#/login"

        then:
        $("h1").text() == "Sign In"
    }
}

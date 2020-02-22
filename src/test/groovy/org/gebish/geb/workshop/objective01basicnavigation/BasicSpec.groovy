package org.gebish.geb.workshop.objective01basicnavigation

import geb.spock.GebSpec
import spock.lang.IgnoreIf

class BasicSpec extends GebSpec {

    @IgnoreIf({ sys['geb.env'] == 'testcontainers' })
    def "go to the main page using an absolute url and verify it contains a div with class home-page"() {
        when:
        go 'http://localhost:3000/'

        then:
        waitFor { $('div.home-page') }
    }

    @IgnoreIf({ sys['geb.env'] == 'testcontainers' })
    def "go to registration page using an absolute url and check text of h1 element"() {
        when:
        go 'http://localhost:3000/#register'

        then:
        waitFor { $('h1').text() == 'Sign Up' }
    }

    @IgnoreIf({ sys['geb.env'] == 'testcontainers' })
    def "go to login page using an absolute url and check text of h1 element"() {
        when:
        go 'http://localhost:3000/#login'

        then:
        waitFor { $('h1').text() == 'Sign In' }
    }

    def "go to the main page using a relative url and verify it contains a div with class home-page"() {
        when:
        go()

        then:
        waitFor { $('div.home-page') }
    }

    def "go to registration page using a relative url and check text of h1 element"() {
        when:
        go '#register'

        then:
        waitFor {  $('h1').text() == 'Sign Up' }
    }

    def "go to login page using a relative url and check text of h1 element"() {
        when:
        go '#login'

        then:
        waitFor { $('h1').text() == 'Sign In' }
    }

}

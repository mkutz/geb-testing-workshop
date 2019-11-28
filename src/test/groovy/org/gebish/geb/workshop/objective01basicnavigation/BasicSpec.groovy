package org.gebish.geb.workshop.objective01basicnavigation

import geb.spock.GebSpec
import groovy.transform.NotYetImplemented
import spock.lang.IgnoreIf

class BasicSpec extends GebSpec {

    @IgnoreIf({ sys['geb.env'] == 'testcontainers' })
    @NotYetImplemented
    def "go to the main page using an absolute url and verify it contains a div with class home-page"() {
        expect:
        false
    }

    @IgnoreIf({ sys['geb.env'] == 'testcontainers' })
    @NotYetImplemented
    def "go to registration page using an absolute url and check text of h1 element"() {
        expect:
        false
    }

    @IgnoreIf({ sys['geb.env'] == 'testcontainers' })
    @NotYetImplemented
    def "go to login page using an absolute url and check text of h1 element"() {
        expect:
        false
    }

    @NotYetImplemented
    def "go to the main page using a relative url and verify it contains a div with class home-page"() {
        expect:
        false
    }

    @NotYetImplemented
    def "go to registration page using a relative url and check text of h1 element"() {
        expect:
        false
    }

    @NotYetImplemented
    def "go to login page using a relative url and check text of h1 element"() {
        expect:
        false
    }

}

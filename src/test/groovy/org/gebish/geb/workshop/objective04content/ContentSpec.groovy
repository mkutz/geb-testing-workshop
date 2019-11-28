package org.gebish.geb.workshop.objective04content

import static java.util.UUID.randomUUID

import geb.spock.GebSpec
import groovy.transform.NotYetImplemented

class ContentSpec extends GebSpec {

    static final String password = 'test1234'

    String username = randomUUID().toString()[0..19]
    String email = "${username}@gebish.org".toString()

    @NotYetImplemented
    def "an error appears when no username is provided upon registration"() {
        expect:
        false
    }

    @NotYetImplemented
    def "can register a new user"() {
        expect:
        false
    }

}

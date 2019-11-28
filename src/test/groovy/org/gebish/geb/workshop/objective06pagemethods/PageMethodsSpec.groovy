package org.gebish.geb.workshop.objective06pagemethods

import geb.spock.GebSpec
import groovy.transform.NotYetImplemented
import org.gebish.geb.workshop.fixture.DataFixture
import spock.lang.AutoCleanup

class PageMethodsSpec extends GebSpec {

    @AutoCleanup
    DataFixture data = new DataFixture()

    @NotYetImplemented
    def "logging in"() {
        given:
        def username = 'loginspecuser'
        def email = "${username}@gebish.org"
        def password = 'password1234'

        and:
        data.getOrCreateUser(
            username: username,
            email: email,
            password: password
        )

        expect:
        false
    }

}

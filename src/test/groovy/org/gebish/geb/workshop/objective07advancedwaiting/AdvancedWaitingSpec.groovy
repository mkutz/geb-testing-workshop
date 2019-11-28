package org.gebish.geb.workshop.objective07advancedwaiting

import geb.spock.GebSpec
import groovy.transform.NotYetImplemented
import org.gebish.geb.workshop.fixture.DataFixture
import spock.lang.AutoCleanup

class AdvancedWaitingSpec extends GebSpec {

    @AutoCleanup
    DataFixture data = new DataFixture()

    @NotYetImplemented
    def "author usernames are displayed on article previews"() {
        given:
        def marcin = data.getOrCreateUserWithName('marcin')
        def michael = data.getOrCreateUserWithName('michael')

        and:
        2.times { data.bootstrapArticleWrittenBy(marcin) }
        2.times { data.bootstrapArticleWrittenBy(michael) }
        data.bootstrapArticleWrittenBy(marcin)

        expect:
        false
    }

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

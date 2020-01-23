package org.gebish.geb.workshop.objective07advancedwaiting

import geb.spock.GebSpec
import org.gebish.geb.workshop.fixture.DataFixture
import org.gebish.geb.workshop.fixture.model.NewUser
import spock.lang.AutoCleanup

class AdvancedWaitingSpec extends GebSpec {

    @AutoCleanup
    DataFixture data = new DataFixture()

    def "author usernames are displayed on article previews"() {
        given:
        def marcin = data.getOrCreateUserWithName('marcin')
        def michael = data.getOrCreateUserWithName('michael')

        and:
        2.times { data.bootstrapArticleWrittenBy(marcin) }
        2.times { data.bootstrapArticleWrittenBy(michael) }
        data.bootstrapArticleWrittenBy(marcin)

        when:
        def homePage = to HomePage
        def previewsByAuthorUsername = homePage.previews.groupBy { it.authorUsername }

        then:
        previewsByAuthorUsername[marcin.username].size() == 3
        previewsByAuthorUsername[michael.username].size() == 2
    }

    def "logging in"() {
        given:
        def username = 'loginspecuser'
        def email = "$username@gebish.org"
        def password = 'password1234'

        and:
        data.getOrCreateUser(
            new NewUser(
                username: username,
                email: email,
                password: password
            )
        )

        when:
        to(LoginPage).login(email, password)

        then:
        at HomePage
    }

}

package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec
import io.github.mkutz.gebtestingworkshop.fixture.DataFixture
import io.github.mkutz.gebtestingworkshop.fixture.model.NewUser
import io.github.mkutz.gebtestingworkshop.page.advancedwaiting.HomePage
import io.github.mkutz.gebtestingworkshop.page.advancedwaiting.LoginPage
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

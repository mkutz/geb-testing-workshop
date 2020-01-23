package org.gebish.geb.workshop.objective06pagemethods

import geb.spock.GebSpec
import org.gebish.geb.workshop.fixture.DataFixture
import org.gebish.geb.workshop.fixture.model.NewUser
import spock.lang.AutoCleanup

class PageMethodsSpec extends GebSpec {

    @AutoCleanup
    DataFixture data = new DataFixture()

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

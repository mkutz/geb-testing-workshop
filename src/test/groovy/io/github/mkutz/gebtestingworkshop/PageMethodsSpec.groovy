package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec
import io.github.mkutz.gebtestingworkshop.fixture.DataFixture
import io.github.mkutz.gebtestingworkshop.fixture.model.NewUser
import io.github.mkutz.gebtestingworkshop.page.content.HomePage
import io.github.mkutz.gebtestingworkshop.page.methods.LoginPage
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

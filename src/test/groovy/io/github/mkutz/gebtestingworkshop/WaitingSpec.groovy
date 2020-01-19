package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec
import io.github.mkutz.gebtestingworkshop.page.at.RegistrationPage

class WaitingSpec extends GebSpec {

    def "an error appears when no username is provided"() {
        when:
        to RegistrationPage

        and:
        $('input', type: 'email').value('user@gebish.org')
        $('input', type: 'password').value("secret")

        and:
        $('button').click()

        then:
        waitFor { $(".error-messages li").text() == "username can't be empty" }
    }

}

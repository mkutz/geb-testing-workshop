package org.gebish.geb.workshop.objective03waiting

import geb.spock.GebSpec

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

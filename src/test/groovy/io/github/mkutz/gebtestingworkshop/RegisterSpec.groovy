package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec

class RegisterSpec extends GebSpec {

    def "go to main page"() {
        when:
        go()

        then:
        title == "Conduit"
    }
}

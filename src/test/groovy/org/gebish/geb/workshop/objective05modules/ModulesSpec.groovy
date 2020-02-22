package org.gebish.geb.workshop.objective05modules

import geb.spock.GebSpec
import org.gebish.geb.workshop.fixture.DataFixture
import spock.lang.AutoCleanup

class ModulesSpec extends GebSpec {

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

        then:
        waitFor { homePage.previews }

        when:
        def previewsByAuthorUsername = homePage.previews.groupBy { it.authorUsername }

        then:
        previewsByAuthorUsername[marcin.username].size() == 3
        previewsByAuthorUsername[michael.username].size() == 2
    }

}

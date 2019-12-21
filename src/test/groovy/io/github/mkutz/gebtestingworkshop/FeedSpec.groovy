package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec

class FeedSpec extends GebSpec {

    def "there are exactly 10 article previews"() {
        given:
        HomePage page = to HomePage

        expect:
        waitFor { page.articlePreviews.size() == 10 }
    }

    def "articles are sorted chronologically"() {
        given:
        HomePage page = to HomePage
        waitFor { page.articlePreviews.size() == 10 }

        expect:
        page.articlePreviews.localDate == page.articlePreviews.localDate.sort(false).reverse()
    }
}

package io.github.mkutz.gebtestingworkshop

import geb.spock.GebSpec
import spock.lang.Ignore

@Ignore("This expects there are at least 10 articles, which need to be created in (global) setup")
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

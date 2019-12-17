package io.github.mkutz.gebtestingworkshop

import geb.Page

class HomePage extends Page {

    static url = "/"

    static at = { $(".feed-toggle") }

    static content = {
        articlePreviews(wait: true) { $(".article-preview") }
    }
}

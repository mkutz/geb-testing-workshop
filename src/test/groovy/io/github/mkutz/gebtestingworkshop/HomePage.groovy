package io.github.mkutz.gebtestingworkshop

import geb.Page

class HomePage extends Page {

    static url = "/"

    static at = { waitFor { $(".home-page") } }

    static content = {
        articlePreviews(wait: true) { $(".article-preview").moduleList(ArticlePreviewModule) }
    }
}

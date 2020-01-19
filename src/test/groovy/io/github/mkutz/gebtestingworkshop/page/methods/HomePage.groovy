package io.github.mkutz.gebtestingworkshop.page.methods

import geb.Page
import io.github.mkutz.gebtestingworkshop.module.ArticlePreview

class HomePage extends Page {

    static at = {
        waitFor { contentWrapper }
    }

    static content = {
        contentWrapper { $('div.home-page') }
        previews { $('.article-preview').moduleList(ArticlePreview) }
    }

}

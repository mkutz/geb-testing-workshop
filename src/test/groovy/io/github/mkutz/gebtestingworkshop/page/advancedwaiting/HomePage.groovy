package io.github.mkutz.gebtestingworkshop.page.advancedwaiting

import geb.Page
import io.github.mkutz.gebtestingworkshop.module.ArticlePreview

class HomePage extends Page {

    static atCheckWaiting = true

    static at = { previews }

    static content = {
        previews { $('.article-preview').moduleList(ArticlePreview) }
    }

}

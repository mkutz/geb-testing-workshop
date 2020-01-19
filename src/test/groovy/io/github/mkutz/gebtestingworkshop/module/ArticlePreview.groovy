package io.github.mkutz.gebtestingworkshop.module

import geb.Module

class ArticlePreview extends Module {

    static content = {
        authorUsername { $('.author').text() }
    }

}

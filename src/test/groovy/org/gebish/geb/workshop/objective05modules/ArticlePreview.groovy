package org.gebish.geb.workshop.objective05modules

import geb.Module

class ArticlePreview extends Module {

    static content = {
        authorUsername { $('.author').text() }
    }

}

package org.gebish.geb.workshop.objective07advancedwaiting

import geb.Module

class ArticlePreview extends Module {

    static content = {
        authorUsername { $('.author').text() }
    }

}

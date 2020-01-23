package org.gebish.geb.workshop.objective06pagemethods

import geb.Module

class ArticlePreview extends Module {

    static content = {
        authorUsername { $('.author').text() }
    }

}

package org.gebish.geb.workshop.objective07advancedwaiting

import geb.Page

class HomePage extends Page {

    static atCheckWaiting = true

    static at = { previews }

    static content = {
        previews { $('.article-preview').moduleList(ArticlePreview) }
    }

}

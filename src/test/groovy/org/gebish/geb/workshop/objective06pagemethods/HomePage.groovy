package org.gebish.geb.workshop.objective06pagemethods

import geb.Page

class HomePage extends Page {

    static at = {
        waitFor { contentWrapper }
    }

    static content = {
        contentWrapper { $('div.home-page') }
        previews { $('.article-preview').moduleList(ArticlePreview) }
    }

}

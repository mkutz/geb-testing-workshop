package org.gebish.geb.workshop.objective07advancedwaiting

import geb.Page

class HomePage extends Page {

    static at = { waitFor { noArticlesMessage || previews } }

    static content = {
        noArticlesMessage(required: false) { $('.article-preview', text: 'No articles are here... yet.') }
        previews { $('.article-preview').has('.article-meta').moduleList(ArticlePreview) }
    }

}

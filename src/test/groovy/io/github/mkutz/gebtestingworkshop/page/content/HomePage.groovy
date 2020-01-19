package io.github.mkutz.gebtestingworkshop.page.content

import geb.Page

class HomePage extends Page {

    static at = {
        waitFor { contentWrapper }
    }

    static content = {
        contentWrapper { $('div.home-page') }
    }

}

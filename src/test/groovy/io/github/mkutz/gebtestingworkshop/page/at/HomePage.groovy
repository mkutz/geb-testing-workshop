package io.github.mkutz.gebtestingworkshop.page.at

import geb.Page

class HomePage extends Page {

    static at = {
        waitFor { $('div.home-page') }
    }

}

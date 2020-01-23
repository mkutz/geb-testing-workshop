package org.gebish.geb.workshop.objective04content

import geb.Page

class HomePage extends Page {

    static at = {
        waitFor { contentWrapper }
    }

    static content = {
        contentWrapper { $('div.home-page') }
    }

}

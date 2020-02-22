package org.gebish.geb.workshop.objective02pages

import geb.Page

class HomePage extends Page {

    static at = {
        waitFor { $('div.home-page') }
    }

}

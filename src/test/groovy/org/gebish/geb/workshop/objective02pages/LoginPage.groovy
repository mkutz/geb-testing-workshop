package org.gebish.geb.workshop.objective02pages

import geb.Page

class LoginPage extends Page {

    static fragment = 'login'

    static at = {
        waitFor { $('h1').text() == 'Sign In' }
    }

}
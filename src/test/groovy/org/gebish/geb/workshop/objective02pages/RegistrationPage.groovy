package org.gebish.geb.workshop.objective02pages

import geb.Page

class RegistrationPage extends Page {

    static fragment = 'register'

    static at = {
        waitFor { $('h1').text() == 'Sign Up' }
    }

}

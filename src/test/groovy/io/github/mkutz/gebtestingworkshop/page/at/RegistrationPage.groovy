package io.github.mkutz.gebtestingworkshop.page.at

import geb.Page

class RegistrationPage extends Page {

    static fragment = 'register'

    static at = {
        waitFor { $('h1').text() == 'Sign Up' }
    }

}

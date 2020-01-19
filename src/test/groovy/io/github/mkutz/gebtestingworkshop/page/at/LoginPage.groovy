package io.github.mkutz.gebtestingworkshop.page.at

import geb.Page

class LoginPage extends Page {

    static fragment = 'login'

    static at = {
        waitFor { $('h1').text() == 'Sign In' }
    }

}

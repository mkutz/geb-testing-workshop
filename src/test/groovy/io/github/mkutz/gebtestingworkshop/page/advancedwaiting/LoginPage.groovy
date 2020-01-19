package io.github.mkutz.gebtestingworkshop.page.advancedwaiting

import geb.Page

class LoginPage extends Page {

    static atCheckWaiting = true

    static fragment = 'login'

    static at = { headerText == 'Sign In' }

    static content = {
        headerText { $('h1').text() }
        email { $('input', type: 'email') }
        password { $('input', type: 'password') }
        submitButton { $('button') }
    }

    void login(String emailValue, String passwordValue) {
        email.value(emailValue)
        password.value(passwordValue)

        submitButton.click()

        browser.at HomePage
    }

}

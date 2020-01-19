package io.github.mkutz.gebtestingworkshop.page.content

import geb.Page

class RegistrationPage extends Page {

    static fragment = 'register'

    static at = {
        waitFor { $('h1').text() == 'Sign Up' }
    }

    static content = {
        username { $('input', type: 'text') }
        email { $('input', type: 'email') }
        password { $('input', type: 'password') }
        submitButton { $('button') }
        errorMessages { $('.error-messages li')*.text() }
    }

}

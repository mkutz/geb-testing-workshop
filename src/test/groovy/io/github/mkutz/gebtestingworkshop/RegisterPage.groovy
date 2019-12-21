package io.github.mkutz.gebtestingworkshop

import geb.Page

class RegisterPage extends Page {

    static url = "/#/register"

    static at = { $("h1").text() == "Sign Up" }

    static content = {
        registerForm { $("form").module(RegisterFormModule) }
        errorMessages(wait: true) { $("ul.error-messages li") }
    }
}

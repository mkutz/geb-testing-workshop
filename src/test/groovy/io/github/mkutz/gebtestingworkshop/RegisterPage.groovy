package io.github.mkutz.gebtestingworkshop

import geb.Page

class RegisterPage extends Page {

    static url = "/#/register"

    static at = { $("h1").text() == "Sign Up" }

    static content = {
        usernameInput { $("input", placeholder: "Username") }
        emailInput { $("input", placeholder: "Email") }
        passwordInput { $("input", placeholder: "Password") }
        submitButton { $("button", type: "submit").click() }
    }
}

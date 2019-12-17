package io.github.mkutz.gebtestingworkshop

import geb.Page

class LoginPage extends Page {

    static url = "/#/login"

    static at = { $("h1").text() == "Sign In" }
}

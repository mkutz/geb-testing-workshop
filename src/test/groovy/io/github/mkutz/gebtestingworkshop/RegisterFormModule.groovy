package io.github.mkutz.gebtestingworkshop

import geb.Module
import geb.module.EmailInput
import geb.module.FormElement
import geb.module.PasswordInput
import geb.module.TextInput

class RegisterFormModule extends Module {

    static content = {
        usernameInput { $("input", placeholder: "Username").module(TextInput) }
        emailInput { $("input", placeholder: "Email").module(EmailInput) }
        passwordInput { $("input", placeholder: "Password").module(PasswordInput) }
        submitButton { $("button", type: "submit").module(FormElement) }
    }

    void register(String username, String email, String password) {
        usernameInput.text = username
        emailInput.text = email
        passwordInput.text = password
        submitButton.click()
    }
}

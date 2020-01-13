package io.github.mkutz.gebtestingworkshop.fixtures.api

import io.github.mkutz.gebtestingworkshop.fixture.model.Credentials

class LoginRequest {
    final Credentials user

    LoginRequest(Credentials credentials) {
        this.user = credentials
    }
}

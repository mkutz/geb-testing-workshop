package org.gebish.geb.workshop.fixture.api

import org.gebish.geb.workshop.fixture.model.Credentials

class LoginRequest {
    final Credentials user

    LoginRequest(Credentials credentials) {
        this.user = credentials
    }
}

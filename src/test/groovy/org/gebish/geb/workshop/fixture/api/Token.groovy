package org.gebish.geb.workshop.fixture.api

import org.gebish.geb.workshop.fixture.model.HasToken

class Token {

    private final String value

    Token(HasToken tokenContainer) {
        this.value = tokenContainer.token
    }

    @Override
    String toString() {
        return "Token ${value}";
    }
}

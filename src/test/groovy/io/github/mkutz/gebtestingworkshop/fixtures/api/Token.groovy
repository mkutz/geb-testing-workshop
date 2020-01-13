package io.github.mkutz.gebtestingworkshop.fixtures.api

import io.github.mkutz.gebtestingworkshop.fixture.model.HasToken

class Token {

    private final String value

    Token(HasToken tokenContainer) {
        this.value = tokenContainer.token
    }

    @Override
    public String toString() {
        return "Token $value";
    }
}

package io.github.mkutz.gebtestingworkshop.fixtures.api

import io.github.mkutz.gebtestingworkshop.fixture.model.NewUser

class CreateUserRequest {

    final NewUser user

    CreateUserRequest(NewUser user) {
        this.user = user
    }

}

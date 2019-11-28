package org.gebish.geb.workshop.fixture.api

import org.gebish.geb.workshop.fixture.model.NewUser

class CreateUserRequest {

    final NewUser user

    CreateUserRequest(NewUser user) {
        this.user = user
    }

}

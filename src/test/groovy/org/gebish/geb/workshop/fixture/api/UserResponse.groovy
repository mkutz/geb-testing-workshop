package org.gebish.geb.workshop.fixture.api

import com.fasterxml.jackson.annotation.JsonCreator
import org.gebish.geb.workshop.fixture.model.User

class UserResponse {

    final User user

    @JsonCreator
    UserResponse(User user) {
        this.user = user
    }

}

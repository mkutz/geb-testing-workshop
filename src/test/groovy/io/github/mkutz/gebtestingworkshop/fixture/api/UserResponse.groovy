package io.github.mkutz.gebtestingworkshop.fixture.api

import com.fasterxml.jackson.annotation.JsonCreator
import io.github.mkutz.gebtestingworkshop.fixture.model.User

class UserResponse {

    final User user

    @JsonCreator
    UserResponse(User user) {
        this.user = user
    }

}

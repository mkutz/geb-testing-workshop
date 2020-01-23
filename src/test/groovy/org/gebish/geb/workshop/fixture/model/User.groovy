package org.gebish.geb.workshop.fixture.model

import com.fasterxml.jackson.annotation.JsonCreator

class User implements HasToken {

    final String email
    final String username
    final String token
    final String bio
    final String image

    @JsonCreator
    User(String email, String username, String token, String bio, String image) {
        this.email = email
        this.username = username
        this.token = token
        this.bio = bio
        this.image = image
    }

}

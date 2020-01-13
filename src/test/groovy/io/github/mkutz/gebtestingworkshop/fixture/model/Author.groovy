package io.github.mkutz.gebtestingworkshop.fixture.model

import com.fasterxml.jackson.annotation.JsonCreator

class Author {

    final String username
    final String bio
    final String image
    final boolean following

    @JsonCreator
    Author(String username, String bio, String image, boolean following) {
        this.username = username
        this.bio = bio
        this.image = image
        this.following = following
    }

}

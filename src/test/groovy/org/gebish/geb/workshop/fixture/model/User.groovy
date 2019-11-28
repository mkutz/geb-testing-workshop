package org.gebish.geb.workshop.fixture.model

import groovy.transform.Immutable

@Immutable
class User implements HasToken {

    String email
    String username
    String token
    String bio
    String image

}

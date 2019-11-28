package org.gebish.geb.workshop.fixture.model

import groovy.transform.Immutable

@Immutable
class NewUser implements Credentials {

    String username
    String password
    String email

}

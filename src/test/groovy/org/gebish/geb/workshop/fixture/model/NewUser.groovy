package org.gebish.geb.workshop.fixture.model

import groovy.transform.MapConstructor

@MapConstructor
class NewUser implements Credentials {

    final String email
    final String username
    final String password

}

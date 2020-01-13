package io.github.mkutz.gebtestingworkshop.fixture.model

import groovy.transform.MapConstructor

@MapConstructor
class NewUser implements Credentials {

    final String email
    final String username
    final String password

}

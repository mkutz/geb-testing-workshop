package org.gebish.geb.workshop.fixture.model

import groovy.transform.Immutable

@Immutable
class NewArticle {

    String title
    String description
    String body
    List<String> tagList = []

}

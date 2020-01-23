package org.gebish.geb.workshop.fixture.model

import groovy.transform.MapConstructor

@MapConstructor
class NewArticle {

    final String title
    final String description
    final String body
    final List<String> tagList = []

}

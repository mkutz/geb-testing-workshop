package io.github.mkutz.gebtestingworkshop.fixture.model

import groovy.transform.MapConstructor

@MapConstructor
class NewArticle {

    final String title
    final String description
    final String body
    final List<String> tagList = []

}

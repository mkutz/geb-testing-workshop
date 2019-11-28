package org.gebish.geb.workshop.fixture.model

import groovy.transform.Immutable

import java.time.ZonedDateTime

@Immutable
class Article {

    String id
    String slug
    String title
    String description
    String body
    List<String> tagList
    ZonedDateTime createdAt
    ZonedDateTime updatedAt
    boolean favorited
    int favoritesCount
    Author author

}

package org.gebish.geb.workshop.fixture.model

import com.fasterxml.jackson.annotation.JsonCreator

import java.time.ZonedDateTime

class Article {

    final String id
    final String slug
    final String title
    final String description
    final String body
    final List<String> tagList
    final ZonedDateTime createdAt
    final ZonedDateTime updatedAt
    final boolean favorited
    final int favoritesCount
    final Author author

    @JsonCreator
    Article(
        String id, String slug, String title, String description, String body, List<String> tagList,
        ZonedDateTime createdAt, ZonedDateTime updatedAt, boolean favorited, int favoritesCount, Author author
    ) {
        this.slug = slug
        this.title = title
        this.description = description
        this.body = body
        this.tagList = tagList
        this.createdAt = createdAt
        this.updatedAt = updatedAt
        this.favorited = favorited
        this.favoritesCount = favoritesCount
        this.author = author
    }

}

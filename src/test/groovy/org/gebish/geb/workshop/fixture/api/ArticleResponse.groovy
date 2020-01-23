package org.gebish.geb.workshop.fixture.api

import com.fasterxml.jackson.annotation.JsonCreator
import org.gebish.geb.workshop.fixture.model.Article

class ArticleResponse {
    final Article article

    @JsonCreator
    ArticleResponse(Article article) {
        this.article = article
    }
}

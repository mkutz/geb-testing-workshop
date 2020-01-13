package io.github.mkutz.gebtestingworkshop.fixtures.api

import com.fasterxml.jackson.annotation.JsonCreator
import io.github.mkutz.gebtestingworkshop.fixture.model.Article

class ArticleResponse {
    final Article article

    @JsonCreator
    ArticleResponse(Article article) {
        this.article = article
    }
}

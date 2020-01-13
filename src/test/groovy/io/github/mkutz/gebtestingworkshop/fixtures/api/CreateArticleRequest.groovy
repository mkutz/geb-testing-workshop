package io.github.mkutz.gebtestingworkshop.fixtures.api

import io.github.mkutz.gebtestingworkshop.fixture.model.NewArticle

class CreateArticleRequest {

    final NewArticle article

    CreateArticleRequest(NewArticle article) {
        this.article = article
    }

}

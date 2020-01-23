package org.gebish.geb.workshop.fixture.api

import org.gebish.geb.workshop.fixture.model.NewArticle

class CreateArticleRequest {

    final NewArticle article

    CreateArticleRequest(NewArticle article) {
        this.article = article
    }

}

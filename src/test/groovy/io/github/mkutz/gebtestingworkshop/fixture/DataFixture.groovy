package io.github.mkutz.gebtestingworkshop.fixture

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.paranamer.ParanamerModule
import io.github.mkutz.gebtestingworkshop.fixture.model.Article
import io.github.mkutz.gebtestingworkshop.fixture.model.Credentials
import io.github.mkutz.gebtestingworkshop.fixture.model.HasToken
import io.github.mkutz.gebtestingworkshop.fixture.model.NewArticle
import io.github.mkutz.gebtestingworkshop.fixture.model.NewUser
import io.github.mkutz.gebtestingworkshop.fixture.model.User
import io.github.mkutz.gebtestingworkshop.fixtures.api.ArticleService
import io.github.mkutz.gebtestingworkshop.fixtures.api.CreateArticleRequest
import io.github.mkutz.gebtestingworkshop.fixtures.api.CreateUserRequest
import io.github.mkutz.gebtestingworkshop.fixtures.api.LoginRequest
import io.github.mkutz.gebtestingworkshop.fixtures.api.Token
import io.github.mkutz.gebtestingworkshop.fixtures.api.UserService
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class DataFixture implements Closeable {

    private final ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new ParanamerModule())
        .registerModule(new JavaTimeModule())

    private final Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://localhost:8080")
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .build();

    private final UserService userService = retrofit.create(UserService)

    private final ArticleService articleService = retrofit.create(ArticleService)

    private final List<TokenAndArticleSlug> createdArticles = []

    User getOrCreateUser(NewUser user) {
        login(user).orElseGet { createUser(user) }
    }

    Article createArticle(HasToken tokenContainer, NewArticle article) {
        def request = new CreateArticleRequest(article)
        def token = new Token(tokenContainer)
        def response = articleService.create(token, request).execute()
        if (!response.successful) {
            throw new HttpException(response)
        }
        def created = response.body().article
        createdArticles << new TokenAndArticleSlug(token, created.slug)
        created
    }

    void close() {
        clearCreatedArticles()
    }

    private User createUser(NewUser user) {
        def request = new CreateUserRequest(user)
        def response = userService.create(request).execute()
        if (!response.successful) {
            throw new HttpException(response)
        }
        response.body().user
    }

    private Optional<User> login(Credentials credentials) {
        def request = new LoginRequest(credentials)
        def response = userService.login(request).execute()
        Optional.ofNullable(response.body()?.user)
    }

    private void deleteArticle(TokenAndArticleSlug article) {
        def response = articleService.delete(article.token, article.slug).execute()
        if (!response.successful) {
            throw new HttpException(response)
        }
    }

    private clearCreatedArticles() {
        createdArticles.each(this.&deleteArticle)
        createdArticles.clear()
    }

    private static class TokenAndArticleSlug {
        final Token token
        final String slug

        TokenAndArticleSlug(Token token, String slug) {
            this.token = token
            this.slug = slug
        }
    }

}

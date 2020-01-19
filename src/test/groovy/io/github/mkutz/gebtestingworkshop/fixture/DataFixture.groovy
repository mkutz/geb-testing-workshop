package io.github.mkutz.gebtestingworkshop.fixture

import static java.util.UUID.randomUUID

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.paranamer.ParanamerModule
import io.github.mkutz.gebtestingworkshop.fixture.api.*
import io.github.mkutz.gebtestingworkshop.fixture.model.*
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

    void bootstrapArticleWrittenBy(User user) {
        def title = randomUUID().toString()
        def article = new NewArticle(
            title: title,
            description: "A description for the article titled $title",
            body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
        )

        createArticle(user, article)
    }

    User getOrCreateUserWithName(String username) {
        def user = new NewUser(
            username: username,
            email: "$username@gebish.org",
            password: 'test1234'
        )

        getOrCreateUser(user)
    }

    User getOrCreateUser(NewUser user) {
        login(user).orElseGet { createUser(user) }
    }

    void close() {
        clearCreatedArticles()
    }

    private Article createArticle(HasToken tokenContainer, NewArticle article) {
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

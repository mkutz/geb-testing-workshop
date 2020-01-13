package io.github.mkutz.gebtestingworkshop.fixtures.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleService {

    @POST("articles")
    Call<ArticleResponse> create(@Header("Authorization") Token token, @Body CreateArticleRequest article)

    @DELETE("articles/{slug}")
    Call<Void> delete(@Header("Authorization") Token token, @Path("slug") String slug)

}
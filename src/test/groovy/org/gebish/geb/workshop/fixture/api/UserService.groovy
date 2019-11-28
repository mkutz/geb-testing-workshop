package org.gebish.geb.workshop.fixture.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("users")
    Call<UserResponse> create(@Body CreateUserRequest body)

    @POST("users/login")
    Call<UserResponse> login(@Body LoginRequest body)

}

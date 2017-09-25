package com.mishkaowner.retrika.util

import com.mishkaowner.retrika.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by MishkaOwner on 2017-09-25.
 */
interface RetrikaService{
    companion object {
        val END_POINT : String = "https://api.github.com"
    }

    @GET("/users")
    fun getUsers(): Observable<List<UserResponse>>
}
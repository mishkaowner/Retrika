package com.mishkaowner.retrika.model

import io.reactivex.Observable


/**
 * Created by MishkaOwner on 2017-09-25.
 */
interface BaseRepository {
    fun getUsers() : Observable<List<User>>

    fun updateUsers(users : List<User>)
}
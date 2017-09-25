package com.mishkaowner.retrika.ui

import com.mishkaowner.retrika.model.User
import io.reactivex.Observable

/**
 * Created by MishkaOwner on 2017-09-25.
 */
interface MainInteractor {
    fun getUsers() : Observable<List<User>>
}
package com.mishkaowner.retrika.model

import com.mishkaowner.retrika.util.RetrikaService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by MishkaOwner on 2017-09-25.
 */
class WebRepository @Inject constructor(val service: RetrikaService) : BaseRepository {
    override fun getUsers(): Observable<List<User>> {
        return service.getUsers().map {
            it.map {
                val user = User(it.id, it.login, it.avatar_url)
                user
            }
        }
    }

    override fun updateUsers(users: List<User>) {
    }
}
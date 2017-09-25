package com.mishkaowner.retrika.ui

import com.mishkaowner.retrika.model.LocalRepository
import com.mishkaowner.retrika.model.User
import com.mishkaowner.retrika.model.WebRepository
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by MishkaOwner on 2017-09-25.
 */

class MainInteractorImpl @Inject constructor(val webRepo: WebRepository, val localRepo: LocalRepository) : MainInteractor {
    private var users: List<User>? = null

    override fun getUsers(): Observable<List<User>> {
        return Maybe.concat(getCurrentUsers(),
                getUsersFromLocal(),
                getUsersFromWeb())
                .firstElement()
                .toObservable()
    }

    private fun getUsersFromWeb(): Maybe<List<User>> {
        return webRepo.getUsers().doOnNext { localRepo.updateUsers(it) }.doOnNext { users = it }.firstElement()
    }

    private fun getUsersFromLocal(): Maybe<List<User>> {
        return localRepo.getUsers().filter { it.isNotEmpty() }.doOnNext { users = it }.firstElement()
    }

    private fun getCurrentUsers(): Maybe<List<User>> {
        return Maybe.fromCallable { users }
    }
}
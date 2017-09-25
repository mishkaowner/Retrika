package com.mishkaowner.retrika.model

import io.reactivex.Observable
import io.realm.Realm

/**
 * Created by MishkaOwner on 2017-09-25.
 */
class LocalRepository : BaseRepository {
    override fun getUsers(): Observable<List<User>> {
        return Observable.fromCallable {
           Realm.getDefaultInstance().use {
               it.where(UserModel::class.java).findAll().map {
                   val user = User(it.id, it.name, it.img)
                   user
               }
           }
        }
    }

    override fun updateUsers(users: List<User>) {
        Realm.getDefaultInstance().executeTransaction { realm ->
            users.forEach{
                val user = UserModel(it.id, it.name, it.avatarUrl)
                realm.insertOrUpdate(user)
            }
        }
    }
}
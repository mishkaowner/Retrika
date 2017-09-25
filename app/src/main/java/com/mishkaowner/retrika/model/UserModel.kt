package com.mishkaowner.retrika.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by MishkaOwner on 2017-09-25.
 */
@RealmClass
open class UserModel(@PrimaryKey open var id: Long = 0,
                     var name: String? = null,
                     var img: String? = null) : RealmObject()
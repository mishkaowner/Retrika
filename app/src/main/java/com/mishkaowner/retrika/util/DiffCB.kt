package com.mishkaowner.retrika.util

import android.support.v7.util.DiffUtil
import com.mishkaowner.retrika.model.User

/**
 * Created by MishkaOwner on 2017-09-25.
 */
class DiffCB(val oldUsers: List<User>, val newUsers: List<User>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUsers[oldItemPosition].id == newUsers[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldUsers.size
    }

    override fun getNewListSize(): Int {
        return newUsers.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldUsers[oldItemPosition] == newUsers[newItemPosition]
    }
}
package com.mishkaowner.retrika.ui

import com.mishkaowner.appbasekotlin.ui.base.BaseView
import com.mishkaowner.retrika.model.User

/**
 * Created by MishkaOwner on 2017-09-25.
 */
interface MainView : BaseView {
    fun updateList(users: List<User>)

    fun setList()
}
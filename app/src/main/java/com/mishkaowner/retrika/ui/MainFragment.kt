package com.mishkaowner.retrika.ui

import android.support.v7.widget.LinearLayoutManager
import com.mishkaowner.appbasekotlin.ui.base.BaseAbstractFragment
import com.mishkaowner.appbasekotlin.ui.base.BasePresenter
import com.mishkaowner.retrika.R
import com.mishkaowner.retrika.RetrikaApp
import com.mishkaowner.retrika.di.MainModule
import com.mishkaowner.retrika.model.User
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * Created by MishkaOwner on 2017-09-25.
 */
class MainFragment : BaseAbstractFragment(), MainView {
    @Inject lateinit var presenter : MainPresenter
    @Inject lateinit var adapter : UserListAdapter
    @Inject lateinit var linearLayoutManager : LinearLayoutManager

    override fun setList() {
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    override fun updateList(users: List<User>) {
        adapter.updateList(users)
    }

    override fun getLayoutID(): Int = R.layout.fragment_main

    override fun getPresenter(): BasePresenter? = presenter

    override fun inject() {
        RetrikaApp.component.plus(MainModule(this)).inject(this)
    }
}

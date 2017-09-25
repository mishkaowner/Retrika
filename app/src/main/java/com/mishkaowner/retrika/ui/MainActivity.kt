package com.mishkaowner.retrika.ui

import android.support.v7.widget.LinearLayoutManager
import com.mishkaowner.appbasekotlin.ui.base.BaseAbstractActivity
import com.mishkaowner.appbasekotlin.ui.base.BasePresenter
import com.mishkaowner.retrika.R
import com.mishkaowner.retrika.RetrikaApp
import com.mishkaowner.retrika.model.User
import com.mishkaowner.retrika.di.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseAbstractActivity(), MainView {
    @Inject lateinit var presenter : MainPresenter

    val adapter : UserListAdapter by lazy { UserListAdapter(ArrayList(), this) }

    override fun setList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun updateList(users: List<User>) {
        adapter.updateList(users)
    }

    override fun getLayoutID(): Int = R.layout.activity_main

    override fun getPresenter(): BasePresenter? = presenter

    override fun inject() {
        RetrikaApp.component.plus(MainModule(this)).inject(this)
    }

}

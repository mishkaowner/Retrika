package com.mishkaowner.retrika.ui

import com.mishkaowner.appbasekotlin.ui.base.BaseAbstractPresenter
import com.mishkaowner.appbasekotlin.util.applyObservableScheduler
import javax.inject.Inject

/**
 * Created by MishkaOwner on 2017-09-25.
 */
class MainPresenterImpl @Inject constructor(view : MainView)
    : BaseAbstractPresenter<MainView>(view), MainPresenter {

    @Inject lateinit var mainInteractor : MainInteractor

    override fun onCreate() {
        super.onCreate()
        view.setList()
    }

    override fun onResume() {
        super.onResume()
        mainInteractor.getUsers().applyObservableScheduler().subscribe({
            view.updateList(it)
        }, { it.printStackTrace() })
    }
}
package com.mishkaowner.retrika.di

import com.mishkaowner.appbasekotlin.di.scope.ActivityScope
import com.mishkaowner.retrika.ui.MainActivity
import dagger.Subcomponent

/**
 * Created by MishkaOwner on 2017-09-25.
 */
@ActivityScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}
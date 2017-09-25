package com.mishkaowner.retrika.di

import com.mishkaowner.appbasekotlin.di.component.BaseAppComponent
import com.mishkaowner.appbasekotlin.di.scope.ApplicationScope
import dagger.Component

/**
 * Created by MishkaOwner on 2017-09-25.
 */
@ApplicationScope
@Component(dependencies = arrayOf(BaseAppComponent::class), modules = arrayOf(RetrikaAppModule::class, ServiceModule::class))
interface RetrikaAppComponent {
    fun plus(module : MainModule) : MainComponent
}
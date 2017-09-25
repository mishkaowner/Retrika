package com.mishkaowner.retrika.di

import com.mishkaowner.appbasekotlin.di.scope.ApplicationScope
import com.mishkaowner.retrika.RetrikaApp
import dagger.Module
import dagger.Provides

/**
 * Created by MishkaOwner on 2017-09-25.
 */
@Module
class RetrikaAppModule (private val app : RetrikaApp) {
    @Provides
    @ApplicationScope
    fun providesApp() : RetrikaApp = app
}
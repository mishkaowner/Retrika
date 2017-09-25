package com.mishkaowner.retrika.di

import com.mishkaowner.appbasekotlin.di.scope.ActivityScope
import com.mishkaowner.retrika.model.LocalRepository
import com.mishkaowner.retrika.model.WebRepository
import com.mishkaowner.retrika.ui.*
import com.mishkaowner.retrika.util.RetrikaService
import dagger.Module
import dagger.Provides

/**
 * Created by MishkaOwner on 2017-09-25.
 */
@Module
class MainModule(private val activity: MainActivity) {
    @Provides @ActivityScope fun providesActivity(): MainActivity = activity
    @Provides @ActivityScope fun providesView(activity: MainActivity): MainView = activity
    @Provides @ActivityScope fun providesPresenter(presenter: MainPresenterImpl): MainPresenter = presenter
    @Provides @ActivityScope fun providesInteractor(interactor: MainInteractorImpl) : MainInteractor = interactor
    @Provides @ActivityScope fun providesWebRepository(service: RetrikaService) : WebRepository = WebRepository(service)
    @Provides @ActivityScope fun providesLocalRepository() : LocalRepository = LocalRepository()
}
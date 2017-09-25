package com.mishkaowner.retrika.di

import android.support.v7.widget.LinearLayoutManager
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
class MainModule(private val fragment: MainFragment) {
    @Provides @ActivityScope fun providesFragment(): MainFragment = fragment
    @Provides @ActivityScope fun providesView(fragment: MainFragment): MainView = fragment
    @Provides @ActivityScope fun providesPresenter(presenter: MainPresenterImpl): MainPresenter = presenter
    @Provides @ActivityScope fun providesInteractor(interactor: MainInteractorImpl): MainInteractor = interactor
    @Provides @ActivityScope fun providesWebRepository(service: RetrikaService): WebRepository = WebRepository(service)
    @Provides @ActivityScope fun providesLocalRepository(): LocalRepository = LocalRepository()
    @Provides @ActivityScope fun providesListAdapter(fragment: MainFragment): UserListAdapter = UserListAdapter(ArrayList(), fragment.context)
    @Provides @ActivityScope fun providesLayoutManager(fragment: MainFragment): LinearLayoutManager = LinearLayoutManager(fragment.context)
}
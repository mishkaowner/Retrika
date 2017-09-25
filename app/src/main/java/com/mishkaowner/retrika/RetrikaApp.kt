package com.mishkaowner.retrika

import com.mishkaowner.appbasekotlin.BaseApp
import com.mishkaowner.appbasekotlin.di.component.DaggerBaseAppComponent
import com.mishkaowner.appbasekotlin.di.module.BaseAppModule
import com.mishkaowner.retrika.di.DaggerRetrikaAppComponent
import com.mishkaowner.retrika.di.RetrikaAppComponent
import com.mishkaowner.retrika.di.RetrikaAppModule
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by MishkaOwner on 2017-09-25.
 */

class RetrikaApp : BaseApp(){
    companion object {
        @JvmStatic
        lateinit var component : RetrikaAppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        val dependency = DaggerBaseAppComponent.builder().baseAppModule(BaseAppModule(this)).build()
        component = DaggerRetrikaAppComponent.builder().baseAppComponent(dependency).retrikaAppModule(RetrikaAppModule(this)).build()
    }
}
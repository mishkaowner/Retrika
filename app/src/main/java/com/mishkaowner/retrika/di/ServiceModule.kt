package com.mishkaowner.retrika.di

import com.google.gson.GsonBuilder
import com.mishkaowner.appbasekotlin.di.scope.ApplicationScope
import com.mishkaowner.retrika.util.RetrikaService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by MishkaOwner on 2017-09-25.
 */
@Module
class ServiceModule{
    @Provides
    @ApplicationScope
    fun providesSainoService(client: OkHttpClient, gsonConverterFactory: GsonConverterFactory): RetrikaService {
        return Retrofit.Builder()
                .baseUrl(RetrikaService.END_POINT)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(RetrikaService::class.java)
    }

    @Provides
    @ApplicationScope
    fun providesGsonConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder().serializeNulls().create()
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @ApplicationScope
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {//TODO might produce errors.
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .writeTimeout(40, TimeUnit.SECONDS).readTimeout(40, TimeUnit.SECONDS).connectTimeout(40, TimeUnit.SECONDS).build()
    }

    @Provides
    @ApplicationScope
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }
}
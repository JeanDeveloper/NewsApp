package com.jchunga.newapp.core.utils

import android.app.Application
import androidx.room.Room
import com.jchunga.newapp.core.utils.Constants.BASE_URL
import com.jchunga.newapp.core.utils.Constants.NEWS_DATABASE_NAME
import com.jchunga.newapp.data.datasource.remote.NewsApi
import com.jchunga.newapp.data.local.NewsDao
import com.jchunga.newapp.data.local.NewsDatabase
import com.jchunga.newapp.data.local.NewsTypeConvertor
import com.jchunga.newapp.data.repository.DataStoreRepository
import com.jchunga.newapp.data.repository.NewsRepository
import com.jchunga.newapp.domain.entity.AppEntryUseCases
import com.jchunga.newapp.domain.entity.NewsUseCases
import com.jchunga.newapp.domain.repository.IDataStoreRepository
import com.jchunga.newapp.domain.repository.INewsRepository
import com.jchunga.newapp.domain.usecases.app_entry.ReadAppEntry
import com.jchunga.newapp.domain.usecases.app_entry.SaveAppEntry
import com.jchunga.newapp.domain.usecases.news.DeleteArticle
import com.jchunga.newapp.domain.usecases.news.GetNews
import com.jchunga.newapp.domain.usecases.news.InsertArticle
import com.jchunga.newapp.domain.usecases.news.SearchNews
import com.jchunga.newapp.domain.usecases.news.SelectArticle
import com.jchunga.newapp.domain.usecases.news.SelectArticles
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideIDataStoreRepository(
        application: Application
    ): IDataStoreRepository = DataStoreRepository(application)

    @Provides
    @Singleton
    fun provideINewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): INewsRepository = NewsRepository(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        dataStoreRepository : IDataStoreRepository
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(dataStoreRepository),
        saveAppEntry = SaveAppEntry(dataStoreRepository),
    )

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: INewsRepository
    ) = NewsUseCases(
        getNews = GetNews(newsRepository),
        searchNews = SearchNews(newsRepository),
        insertArticle = InsertArticle(newsRepository),
        deleteArticle = DeleteArticle(newsRepository),
        selectArticles = SelectArticles(newsRepository),
        selectArticle = SelectArticle(newsRepository)
    )

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}
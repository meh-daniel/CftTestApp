package test.task.cft.focus.start.com.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import test.task.cft.focus.start.com.data.BinRepositoryImpl
import test.task.cft.focus.start.com.data.nw.BinApi
import test.task.cft.focus.start.com.domain.BinRepository
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideSessionRepository(
        @Named("GitHubApi") binApi: BinApi
    ) : BinRepository {
        return BinRepositoryImpl(binApi)
    }
}
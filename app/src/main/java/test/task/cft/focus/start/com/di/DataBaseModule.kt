package test.task.cft.focus.start.com.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import test.task.cft.focus.start.com.data.db.BinDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun createSerialDataBase(
        @ApplicationContext context: Context
    ): BinDataBase {
        return BinDataBase.invoke(context)
    }

}
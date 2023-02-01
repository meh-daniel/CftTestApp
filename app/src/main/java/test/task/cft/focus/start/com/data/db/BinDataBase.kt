package test.task.cft.focus.start.com.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import test.task.cft.focus.start.com.data.db.model.BinSW

@Database(
    entities = arrayOf(
        BinSW::class,
    ),
    version = BinDataBase.DB_VERSION,
    exportSchema = false,
)
abstract class BinDataBase: RoomDatabase() {
    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "bin.db"

        @Volatile private var instance : BinDataBase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            BinDataBase::class.java,
            DB_NAME
        ).build()
    }
    abstract fun binDao(): BinDao
}
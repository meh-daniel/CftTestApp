package test.task.cft.focus.start.com.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import test.task.cft.focus.start.com.data.db.model.BinSW

@Dao
interface BinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBin(bin: BinSW)

    @Query("SELECT * FROM bin ")
    suspend fun getBin() : List<BinSW>

}
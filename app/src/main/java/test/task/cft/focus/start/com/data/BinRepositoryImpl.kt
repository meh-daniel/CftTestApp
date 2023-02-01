package test.task.cft.focus.start.com.data

import android.util.Log
import test.task.cft.focus.start.com.data.db.BinDataBase
import test.task.cft.focus.start.com.data.nw.BinApi
import test.task.cft.focus.start.com.domain.BinRepository
import test.task.cft.focus.start.com.domain.model.Bin

class BinRepositoryImpl(
    private val db: BinDataBase,
    private val api: BinApi
): BinRepository {

    override suspend fun getBy(numberCard: String): Bin {
        val data = api.getBin(numberCard).toDomain(numberCard)
        db.binDao().insertBin(data.toSW(numberCard))
        Log.d("xxx123", "db ${db.binDao().getBin().toDomain()}")
        return data
    }

    override suspend fun get(): List<Bin> {
        return db.binDao().getBin().toDomain()
    }

}
package test.task.cft.focus.start.com.data

import android.util.Log
import test.task.cft.focus.start.com.data.nw.BinApi
import test.task.cft.focus.start.com.data.nw.model.BinNW
import test.task.cft.focus.start.com.domain.BinRepository
import test.task.cft.focus.start.com.domain.model.Bin

class BinRepositoryImpl(
    private val api: BinApi
): BinRepository {

    override suspend fun search(bin: Int): Bin {
        Log.d("xxx123", "${api.getBin(bin.toString())}")
        return api.getBin(bin.toString()).toDomain(bin)
    }

}
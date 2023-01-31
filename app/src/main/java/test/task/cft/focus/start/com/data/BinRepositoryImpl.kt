package test.task.cft.focus.start.com.data

import test.task.cft.focus.start.com.data.nw.BinApi
import test.task.cft.focus.start.com.data.nw.model.BinNW
import test.task.cft.focus.start.com.domain.BinRepository
import test.task.cft.focus.start.com.domain.model.Bin

class BinRepositoryImpl(
    private val api: BinApi
): BinRepository {

    override suspend fun search(bin: Int): Bin {
        return api.getBin(bin.toString()).toDomain(bin)
    }

}
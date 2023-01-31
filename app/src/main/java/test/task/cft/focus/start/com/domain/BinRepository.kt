package test.task.cft.focus.start.com.domain

import test.task.cft.focus.start.com.domain.model.Bin

interface BinRepository {

    suspend fun search(bin: Int): Bin

}
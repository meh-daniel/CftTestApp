package test.task.cft.focus.start.com.domain

import test.task.cft.focus.start.com.domain.model.Bin

interface BinRepository {

    fun search(bin: Int): Bin

}
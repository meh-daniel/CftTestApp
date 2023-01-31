package test.task.cft.focus.start.com.data

import test.task.cft.focus.start.com.data.nw.model.BinNW
import test.task.cft.focus.start.com.domain.model.Bin

internal  fun BinNW.toDomain(bin: Int): Bin {
    return Bin(
        bin = bin
    )
}
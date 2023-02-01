package test.task.cft.focus.start.com.data.nw

import retrofit2.http.GET
import retrofit2.http.Path
import test.task.cft.focus.start.com.data.nw.model.BinNW

interface BinApi {
    @GET("/{bin}")
    suspend fun getBin(@Path("bin") bin: String): BinNW
}
package cz.respect.respectsportapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(LOCALHOST_SERVER_URL)
    .build()

interface RespectSportApiService {
    @GET(LOCALHOST_TEST_URL)
    suspend fun getMatches(): String
}

interface RespectSportApiLoginService {
    @GET("respect_table_tennis/www/98789789789079889789/test")
    suspend fun logIn(): String
}

object RespectSportApi {
    val retrofitService : RespectSportApiService by lazy {
        retrofit.create(RespectSportApiService::class.java) }
}
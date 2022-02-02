package cz.respect.respectsportapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_API_URL = "http://10.0.2.2"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_API_URL)
    .build()

interface RespectSportApiService {
    @GET("respect_table_tennis/www/98789789789079889789/test")
    suspend fun getPhotos(): String
}

object RespectSportApi {
    val retrofitService : RespectSportApiService by lazy {
        retrofit.create(RespectSportApiService::class.java) }
}
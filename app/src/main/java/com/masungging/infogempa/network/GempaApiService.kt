package com.masungging.infogempa.network

import com.masungging.infogempa.model.DataGempa
import com.masungging.infogempa.model.ItemGempa
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// URL dasar untuk mengakses data dari server
private const val BASE_URL =
    "https://data.bmkg.go.id/DataMKG/TEWS/"

// Objek moshi yang digunakan Retrofit untuk mengurai respon JSON
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Objek retrofit dengan moshi converter untuk menampilkan daftar objek dari array JSON
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// Antarmuka publik yang menampilkan metode getGempaTerkini.
interface GempaApiService {
    // Fungsi GET untuk mengambil data dari server
    @GET("gempaterkini.json")
    suspend fun getGempaTerkini(): List<ItemGempa>
}

// Objek Api publik yang menampilkan layanan Retrofit yang diinisialisasi lambat
object GempaTerkiniApi {
    val retrofitService : GempaApiService by lazy {
        retrofit.create(GempaApiService::class.java)
    }
}

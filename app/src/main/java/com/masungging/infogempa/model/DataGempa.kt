package com.masungging.infogempa.model

import com.squareup.moshi.Json

// Definisi data dari respon JSON dan
// nama properti yang akan dicocokan dengan nama nilai di JSON
data class DataGempa(
    @Json(name = "Infogempa")
    val infogempa: InfoGempa? = null,
)

data class InfoGempa(
    val gempa: List<ItemGempa>? = null
)

data class ItemGempa(
    @Json(name = "Tanggal") val tanggal: String,
    @Json(name = "Jam") val jam: String,
    @Json(name = "DateTime") val dateTime: String,
    @Json(name = "Coordinates") val coordinates: String,
    @Json(name = "Lintang") val lintang: String,
    @Json(name = "Bujur") val bujur: String,
    @Json(name = "Magnitude") val magnitude: String,
    @Json(name = "Kedalaman") val kedalaman: String,
    @Json(name = "Wilayah") val wilayah: String,
    @Json(name = "Potensi") val potensi: String
)

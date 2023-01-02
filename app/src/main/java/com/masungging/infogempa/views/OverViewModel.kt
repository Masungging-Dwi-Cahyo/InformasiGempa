package com.masungging.infogempa.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masungging.infogempa.model.ItemGempa
import com.masungging.infogempa.network.GempaTerkiniApi
import kotlinx.coroutines.launch

enum class GempaApiStatus {LOADING, ERROR, DONE}

class OverViewModel : ViewModel() {

    // Properti untuk merepresentasikan status API
    private val _status = MutableLiveData<GempaApiStatus>()
    val status: LiveData<GempaApiStatus> = _status

    // Properti untuk menampilkan daftar objek gempa
    private val _gempa = MutableLiveData<List<ItemGempa>>()
    val gempa : LiveData<List<ItemGempa>> =_gempa

    // Properti untuk menampilkan detail tampilan saat item daftar diklik
    private val _detail = MutableLiveData<ItemGempa>()
    val detail : LiveData<ItemGempa> =_detail

    // Fungsi untuk mendapatkan daftar dari layanan API dengan berdasarkan status
    fun getGempaTerkiniList() {
        viewModelScope.launch {
            _status.value = GempaApiStatus.LOADING
            try {
                _gempa.value = GempaTerkiniApi.retrofitService.getGempaTerkini()
                _status.value = GempaApiStatus.DONE

            } catch (e: Exception) {
                _status.value = GempaApiStatus.ERROR
                _gempa.value = listOf()
            }
        }
    }

    // Fungsi untuk menampilkan item detail
    fun onGempaTerkiniClicked(gempa: ItemGempa) {
        _detail.value = gempa
    }
}
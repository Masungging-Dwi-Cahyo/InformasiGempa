package com.masungging.infogempa.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.masungging.infogempa.R
import com.masungging.infogempa.model.ItemGempa
import com.masungging.infogempa.views.GempaApiStatus

// Fungsi untuk menampilkan data baru
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ItemGempa>?) {
    val adapter = recyclerView.adapter as ListGempaAdapter
    adapter.submitList(data)
}

// Fungsi untuk menampilkan status permintaan pada layanan API berdasarkan pada kondisi
@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: GempaApiStatus?) {
    when(status) {
        GempaApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        GempaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        GempaApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        else -> {}
    }
}
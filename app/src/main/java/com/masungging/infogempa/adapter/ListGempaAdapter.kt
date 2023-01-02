package com.masungging.infogempa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.masungging.infogempa.databinding.ListViewItemBinding
import com.masungging.infogempa.model.ItemGempa

// Kelas atau adapter untuk menampilkan list data menggunakan Data Binding
class ListGempaAdapter(val clickListener: GempaListener):
    ListAdapter<ItemGempa, ListGempaAdapter.GempaViewHolder>(DiffCallback) {

    // List data dengan Data Binding dan menetapkan clickListener
    class GempaViewHolder(var binding: ListViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: GempaListener, itemGempa: ItemGempa) {
            binding.data = itemGempa
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    // Objek pembanding antara data yang baru dengan data yang lama
    companion object DiffCallback : DiffUtil.ItemCallback<ItemGempa>() {

        override fun areItemsTheSame(oldItem: ItemGempa, newItem: ItemGempa): Boolean {
            return oldItem.wilayah == newItem.wilayah && oldItem.tanggal == newItem.tanggal &&
                    oldItem.potensi == newItem.potensi && oldItem.magnitude == newItem.magnitude
        }

        override fun areContentsTheSame(oldItem: ItemGempa, newItem: ItemGempa): Boolean {
            return oldItem.kedalaman == newItem.kedalaman && oldItem.lintang == newItem.lintang &&
                    oldItem.tanggal == newItem.tanggal && oldItem.jam == newItem.jam &&
                    oldItem.magnitude == newItem.magnitude && oldItem.wilayah == newItem.wilayah &&
                    oldItem.potensi == newItem.potensi
        }

    }

    // Fungsi untuk membuat GempaViewHolder dengan meng-inflate ListViewItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GempaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GempaViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    // Fungsi untuk mendapatkan informasi detail dengan clickListener
    override fun onBindViewHolder(holder: GempaViewHolder, position: Int) {
        val detail = getItem(position)
        holder.bind(clickListener, detail)
    }
}

// Fungsi untuk menetapkan clickListener dengan mengambil informasi detail
class GempaListener(val clickListener: (detail: ItemGempa) -> Unit) {
    fun onClick(detail: ItemGempa) = clickListener(detail)
}

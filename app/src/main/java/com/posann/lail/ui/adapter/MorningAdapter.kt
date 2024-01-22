package com.posann.lail.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.posann.lail.data.response.DataItem
import com.posann.lail.databinding.ItemDzikirBinding

class MorningAdapter(val listM: ArrayList<DataItem>): RecyclerView.Adapter<MorningAdapter.ListViewHolder>() {

    // menentukan view yang digunakan pada layout (item_dzikir.xml)
    class ListViewHolder(binding: ItemDzikirBinding): RecyclerView.ViewHolder(binding.root) {

        private var notes = binding.tvNotes
        private var title = binding.tvTitle
        private var fawaid = binding.tvFawaid
        private var source = binding.tvSource
        private var arabic = binding.tvArabic

        fun setData(listDzikir: DataItem) {
            notes.text = listDzikir.notes
            title.text = listDzikir.title
            fawaid.text = listDzikir.fawaid
            source.text = listDzikir.source
            arabic.text = listDzikir.arabic
        }
    }

    // untuk membuat lifecycle onCreate pada class kotlin
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemDzikirBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    // untuk menentukan jumlah data yang akan ditampilkan
    override fun getItemCount(): Int {
        return listM.size
    }

    // untuk menentukan posisi data dan memberi nilai dari variabel yang ada di ListViewHolder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listM[position]
        holder.setData(data)
    }
}
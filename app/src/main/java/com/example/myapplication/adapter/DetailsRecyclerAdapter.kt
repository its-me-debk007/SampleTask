package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDetailsBinding

class DetailsRecyclerAdapter(
    private val data: List<String>
) : RecyclerView.Adapter<DetailsRecyclerAdapter.DetailsViewHolder>() {

    inner class DetailsViewHolder(val binding: ItemDetailsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder =
        DetailsViewHolder(
            ItemDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.binding.detail.text = data[position]
    }
}
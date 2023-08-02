package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Entry
import com.example.myapplication.databinding.ItemTextviewBinding

class MyRecyclerAdapter(
    private val data: List<Entry>
) : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemTextviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemTextviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.textView.text = data[position].Description
    }


}
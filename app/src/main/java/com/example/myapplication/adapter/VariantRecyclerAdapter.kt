package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemVariantBinding

class VariantRecyclerAdapter(
    private val context: Context
) : RecyclerView.Adapter<VariantRecyclerAdapter.VariantViewHolder>() {

    inner class VariantViewHolder(val binding: ItemVariantBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariantViewHolder =
        VariantViewHolder(
            ItemVariantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: VariantViewHolder, position: Int) {
        holder.binding.apply {
            if (position == 0) {
                radioBtn.isChecked = true
                cardView.strokeColor = ContextCompat.getColor(context, R.color.yellow)
            }

        }
    }
}
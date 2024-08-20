package com.example.pokeapp.genAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.data.GenerationInfo
import com.example.pokeapp.databinding.ItemGenerationBinding

class GenerationViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val binding = ItemGenerationBinding.bind(view)

    fun bind(generation: GenerationInfo, onItemSelected: (GenerationInfo) -> Unit){
        binding.tvGeneration.text = generation.name
        binding.ivGeneration.setImageResource(generation.img)
        binding.root.setOnClickListener { onItemSelected(generation) }
    }
}
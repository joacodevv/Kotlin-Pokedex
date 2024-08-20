package com.example.pokeapp.genAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.data.GenerationInfo

class GenerationAdapter(private val onItemSelected: (GenerationInfo) -> Unit) :
    RecyclerView.Adapter<GenerationViewHolder>() {

    private val generationList: List<GenerationInfo> = listOf(
    GenerationInfo.GenerationI,
    GenerationInfo.GenerationII,
    GenerationInfo.GenerationIII,
    GenerationInfo.GenerationIV,
    GenerationInfo.GenerationV,
    GenerationInfo.GenerationVI,
    GenerationInfo.GenerationVII,
    GenerationInfo.GenerationVIII,
    GenerationInfo.GenerationIX
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerationViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_generation, parent, false)
        return GenerationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return generationList.size
    }

    override fun onBindViewHolder(holder: GenerationViewHolder, position: Int) {
        holder.bind(generationList[position], onItemSelected)
    }
}
package com.example.pokeapp.ui.pokeAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.data.PokeModel
import com.example.pokeapp.R

class PokemonAdapter(
    private var pokeList: List<PokeModel> = emptyList(),
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<PokemonViewHolder>() {

    fun updateList(pokeList: List<PokeModel>) {
        this.pokeList = pokeList
        notifyDataSetChanged()
        Log.i("Pokelista", pokeList.size.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokeList[position], onItemSelected)
    }

}
package com.example.pokeapp.data

import com.example.pokeapp.R

sealed class GenerationInfo(val img: Int, val name: String) {
    data object GenerationI : GenerationInfo(R.drawable.gen1, "Generation I")
    data object GenerationII : GenerationInfo(R.drawable.gen2, "Generation II")
    data object GenerationIII : GenerationInfo(R.drawable.gen3, "Generation III")
    data object GenerationIV : GenerationInfo(R.drawable.gen4, "Generation IV")
    data object GenerationV : GenerationInfo(R.drawable.gen5, "Generation V")
    data object GenerationVI : GenerationInfo(R.drawable.gen6, "Generation VI")
    data object GenerationVII : GenerationInfo(R.drawable.gen7, "Generation VII")
    data object GenerationVIII : GenerationInfo(R.drawable.gen8, "Generation VIII")
    data object GenerationIX : GenerationInfo(R.drawable.gen9, "Generation IX")
}
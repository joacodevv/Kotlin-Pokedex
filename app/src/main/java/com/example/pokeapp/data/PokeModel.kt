package com.example.pokeapp.data

import com.google.gson.annotations.SerializedName

data class AllPokemonModel(
    @SerializedName("results") val results: List<PokemonBasicInfo>
)

data class PokemonBasicInfo(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class PokeModel(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("sprites") val sprites: SpritesModel,
    @SerializedName("types") val types: List<TypeModel>,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("stats") val stats: List<StatModel>
)

data class StatModel(
    @SerializedName("base_stat") val baseStat: Int,
    @SerializedName("stat") val stat: StatInfoModel
)

data class StatInfoModel(
    @SerializedName("name") val statName: String
)

data class TypeModel(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: TypeInfoModel
)
data class TypeInfoModel(
    @SerializedName("name") val name: String
)

data class SpritesModel(
    @SerializedName("front_default") val frontDefault: String
)

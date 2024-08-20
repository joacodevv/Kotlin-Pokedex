package com.example.pokeapp.data.api

import com.example.pokeapp.data.AllPokemonModel
import com.example.pokeapp.data.PokeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("pokemon/?limit=151")
    suspend fun getAllPokemon():Response<AllPokemonModel>

    @GET("pokemon/{name}")
    suspend fun getAllPokemonBasicInfo(@Path("name") name: String):Response<PokeModel>

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(@Path("name") name: String):Response<PokeModel>

}
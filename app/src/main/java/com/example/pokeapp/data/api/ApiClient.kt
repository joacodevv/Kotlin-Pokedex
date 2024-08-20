package com.example.pokeapp.data.api

import com.example.pokeapp.data.AllPokemonModel
import com.example.pokeapp.data.PokeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("pokemon/?limit=151")
    suspend fun getAllGen1Pokemon():Response<AllPokemonModel>

    @GET("pokemon/?limit=100&offset=151")
    suspend fun getAllGen2Pokemon():Response<AllPokemonModel>

    @GET("pokemon/?limit=135&offset=251")
    suspend fun getAllGen3Pokemon():Response<AllPokemonModel>

    @GET("pokemon/?limit=108&offset=386")
    suspend fun getAllGen4Pokemon():Response<AllPokemonModel>

    @GET("pokemon/?limit=155&offset=494")
    suspend fun getAllGen5Pokemon():Response<AllPokemonModel>

    @GET("pokemon/?limit=72&offset=649")
    suspend fun getAllGen6Pokemon():Response<AllPokemonModel>

    @GET("pokemon/?limit=91&offset=721")
    suspend fun getAllGen7Pokemon():Response<AllPokemonModel>

    @GET("https://pokeapi.co/api/v2/pokemon?limit=93&offset=812")
    suspend fun getAllGen8Pokemon():Response<AllPokemonModel>

    @GET("pokemon/?limit=120&offset=905")
    suspend fun getAllGen9Pokemon():Response<AllPokemonModel>

    @GET("pokemon/{name}")
    suspend fun getAllPokemonBasicInfo(@Path("name") name: String):Response<PokeModel>

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(@Path("name") name: String):Response<PokeModel>

}
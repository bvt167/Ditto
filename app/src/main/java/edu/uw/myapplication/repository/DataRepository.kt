package edu.uw.myapplication.repository

import edu.uw.myapplication.`interface`.PokemonService
import edu.uw.myapplication.model.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * https://pokeapi.co/api/v2/
 */

class DataRepository {

    private val pokemonService = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokemonService::class.java)

    suspend fun getPokemon(name: String): Pokemon = pokemonService.getPokemon(name)
}
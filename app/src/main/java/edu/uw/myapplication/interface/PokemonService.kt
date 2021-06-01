package edu.uw.myapplication.`interface`

import edu.uw.myapplication.model.Pokemon
import edu.uw.myapplication.model.PokemonList
import edu.uw.myapplication.model.PokemonSpecies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Pokemon

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecies(
        @Path("name") name: String
    ): PokemonSpecies

    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("limit") limit: Int
    ): PokemonList
}
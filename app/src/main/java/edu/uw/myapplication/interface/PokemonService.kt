package edu.uw.myapplication.`interface`

import edu.uw.myapplication.model.Pokemon
import edu.uw.myapplication.model.PokemonList
import edu.uw.myapplication.model.Species
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Pokemon

    @GET("pokemon/")
    suspend fun getPokemonList(
        @Query("limit") limit: Int
    ): PokemonList

    @GET("pokemon-species/{name}")
    suspend fun getPokemonHints(
        @Path("name") name: String
    ): Species
}
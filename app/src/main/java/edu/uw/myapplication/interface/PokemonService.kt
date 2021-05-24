package edu.uw.myapplication.`interface`

import edu.uw.myapplication.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("https://pokeapi.co/api/v2/pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Pokemon
}
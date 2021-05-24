package edu.uw.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonList(
    val count: Int,
    val results: List<PokemonListItem>
): Parcelable

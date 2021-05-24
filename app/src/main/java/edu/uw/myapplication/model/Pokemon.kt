package edu.uw.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val forms: List<Form>,
    val sprites: Sprites
): Parcelable

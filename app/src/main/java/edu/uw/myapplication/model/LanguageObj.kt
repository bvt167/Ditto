package edu.uw.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LanguageObj(
    val name: String,
): Parcelable

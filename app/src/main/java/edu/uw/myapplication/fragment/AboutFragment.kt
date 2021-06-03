package edu.uw.myapplication.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.myapplication.BuildConfig
import edu.uw.myapplication.activity.POKEMON_NAME_KEY
import edu.uw.myapplication.activity.PokemonDetailActivity
import edu.uw.myapplication.databinding.FragmentAboutBinding


class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutBinding.inflate(layoutInflater)
        with(binding) {
            versionOf.text = BuildConfig.VERSION_NAME
        }
        return binding.root
    }
}
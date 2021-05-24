package edu.uw.myapplication.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import coil.load
import edu.uw.myapplication.DittoApplication
import edu.uw.myapplication.R
import edu.uw.myapplication.databinding.ActivityPokemonDetailBinding
import edu.uw.myapplication.repository.DataRepository
import kotlinx.coroutines.launch

const val POKEMON_NAME_KEY = "POKEMON_NAME_KEY"

fun navigateToPokemonDetailActivity(context: Context, pokemonName: String) = with(context) {
    val intent = Intent(this, PokemonDetailActivity::class.java).apply {
        val bundle = Bundle().apply {
            putString(POKEMON_NAME_KEY, pokemonName)
        }
        putExtras(bundle)
    }
    startActivity(intent)
}

class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding
    private val application by lazy { applicationContext as DittoApplication }
    private val dataRepository by lazy { application.dataRepository }
    private var pokemonName: String? = "ditto"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonDetailBinding.inflate(layoutInflater).apply { setContentView(root) }
        pokemonName = intent.getStringExtra(POKEMON_NAME_KEY)

        lifecycleScope.launch {
            val pokemon = dataRepository.getPokemon("ditto")
            with (binding) {
                pokemon.sprites.other.`official-artwork`?.front_default.let { ivPokemonArt.load(it) }
                tvPokemonName.text = pokemon.forms[0].name
            }
        }
    }
}
package edu.uw.myapplication.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import coil.load
import edu.uw.myapplication.DittoApplication
import edu.uw.myapplication.NavGraphDirections
import edu.uw.myapplication.R
import edu.uw.myapplication.databinding.ActivityPokemonDetailBinding
import edu.uw.myapplication.model.Pokemon
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
    private var pokemonName: String = "ditto"
    private val navController by lazy { findNavController(R.id.navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityPokemonDetailBinding.inflate(layoutInflater).apply { setContentView(root) }
        intent.getStringExtra(POKEMON_NAME_KEY)?.let {
            pokemonName = it
        }

        loadPokemonData()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun loadPokemonData() {
        lifecycleScope.launch {
            val pokemon = dataRepository.getPokemon(pokemonName)
            navController.navigate(NavGraphDirections.actionGlobalAboutFragment(pokemon))
            setFragmentNavigation(pokemon)
            with(binding) {
                pokemon.sprites.other.`official-artwork`?.front_default.let { ivPokemonArt.load(it) }
                tvPokemonName.text = capitalizeWords(pokemon.forms[0].name)
                clContainer.setBackgroundColor(application.getTypeColorByName(pokemon.types.first().type.name))
            }
        }
    }

    private fun setFragmentNavigation(pokemon: Pokemon) {
        with(binding) {
            rbAbout.setOnClickListener {
                navController.navigate(NavGraphDirections.actionGlobalAboutFragment(pokemon))
            }

            rbStats.setOnClickListener {
                navController.navigate(NavGraphDirections.actionGlobalStatsFragment(pokemon))
            }

            rbEvolutions.setOnClickListener {
                navController.navigate(NavGraphDirections.actionGlobalEvolutionsFragment(pokemon))
            }

            rbMoves.setOnClickListener {
                navController.navigate(NavGraphDirections.actionGlobalMovesFragment(pokemon))
            }
        }
    }

    private fun capitalizeWords(s: String): String = s.split(" ").joinToString { it.replaceFirstChar { it.uppercaseChar() } }

}
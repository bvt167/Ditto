package edu.uw.myapplication.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import coil.load
import edu.uw.myapplication.DittoApplication
import edu.uw.myapplication.R
import edu.uw.myapplication.databinding.ActivityGuessingGameBinding
import edu.uw.myapplication.databinding.ActivityMainBinding
import edu.uw.myapplication.databinding.ActivityPokemonDetailBinding
import edu.uw.myapplication.model.Species
import kotlinx.coroutines.launch

val PREFERED_LANGUAGE_KEY = "en"

fun navigateToGuessingGameActivity(context: Context) = with(context) {
    val intent = Intent(this, GuessingGameActivity::class.java)
    startActivity(intent)
}

class GuessingGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuessingGameBinding
    private val application by lazy { applicationContext as DittoApplication }
    private val dataRepository by lazy { application.dataRepository }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guessing_game)

        binding = ActivityGuessingGameBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {
            startGameBtn.setOnClickListener{
                setUpQuestion()
            }
        }
    }

    fun setUpQuestion() {
        with(binding) {
            lifecycleScope.launch {
                val randomPokemonName = dataRepository.getPokemonList().results.random().name
                val pokemon = dataRepository.getPokemon(randomPokemonName)
                Log.i("PokeHint", "ID: ${pokemon.name}, Name: ${pokemon.name}")
                val hints = dataRepository.getPokemonHint(randomPokemonName)

                var langIndex = findLangFlavorText(hints)

                var hintFlavorText = hints.flavor_text_entries[langIndex].flavor_text
                hintFlavorText = hintFlavorText.replace("\\n".toRegex(), "") // removes new lines
                hintFlavorText = hintFlavorText.replace(pokemon.name, "?", true) // removes pokemon name in case it's in the flavor text string
                descHintTv.text = hintFlavorText
                Log.i("PokeHint", hints.flavor_text_entries[langIndex].flavor_text)
                pokemon.sprites.other.`official-artwork`?.front_default.let { pkmnSprite.load(it) }
            }
        }
    }

    fun findLangFlavorText(hints: Species): Int {
        var index = 0

        for (i in hints.flavor_text_entries){
            Log.i("PokeHint", i.language.name)
            if (i.language.name == PREFERED_LANGUAGE_KEY) {
                return index
            }
            index++
        }
        return index
    }
}
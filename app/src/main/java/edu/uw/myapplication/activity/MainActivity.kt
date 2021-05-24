package edu.uw.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {
            binding.btnNavigatePokemonDetail.setOnClickListener {
                navigateToPokemonDetailActivity(this@MainActivity, "ditto")
            }
        }

    }
}
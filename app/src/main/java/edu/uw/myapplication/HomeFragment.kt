package edu.uw.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import edu.uw.myapplication.activity.navigateToPokemonDetailActivity
import edu.uw.myapplication.databinding.ActivityMainBinding
import edu.uw.myapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val navController by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentHomeBinding.inflate(inflater)

        with(binding) {

            btnAbout.setOnClickListener{
                navController.navigate(R.id.aboutFragment)
            }




        }


        return binding.root
    }

}
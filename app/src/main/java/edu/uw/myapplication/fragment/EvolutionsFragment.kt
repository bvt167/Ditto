package edu.uw.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.myapplication.databinding.FragmentEvolutionsBinding

class EvolutionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEvolutionsBinding.inflate(layoutInflater)

        return binding.root
    }

}
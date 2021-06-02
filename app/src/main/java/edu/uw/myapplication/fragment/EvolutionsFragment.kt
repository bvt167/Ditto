package edu.uw.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.myapplication.databinding.FragmentEvolutionsBinding
import edu.uw.myapplication.databinding.FragmentStatsBinding

class EvolutionsFragment : Fragment() {

    private lateinit var binding: FragmentEvolutionsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentEvolutionsBinding.inflate(layoutInflater)

        return binding.root
    }

}
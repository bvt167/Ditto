package edu.uw.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uw.myapplication.BuildConfig
import edu.uw.myapplication.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAboutBinding.inflate(layoutInflater)
        with(binding) {
            version.text = BuildConfig.VERSION_NAME
        }
        return binding.root
    }
}
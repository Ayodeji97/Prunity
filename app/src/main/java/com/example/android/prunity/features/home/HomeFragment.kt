package com.example.android.prunity.features.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.android.prunity.R
import com.example.android.prunity.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var ui : FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ui = FragmentHomeBinding.bind(view)
        ui.fragmentHomeToolbar.appToolbar.setNavigationIcon(R.drawable.arrow)

        setupViews()
    }

    private fun setupViews(){
        ui.pruneBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Prune clicked", Toast.LENGTH_SHORT).show()
        }

        ui.pruneBtn.isEnabled = true

    }
}
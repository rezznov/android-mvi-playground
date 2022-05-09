package com.reznov.android_mvi_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.reznov.android_mvi_playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var _binding:ActivityMainBinding? = null
    val binding:ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Navigation.findNavController(this, R.id.fragmentContainerView)
    }
}
package com.example.musicwiki

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.musicwiki.databinding.ActivityMainBinding
import com.example.musicwiki.viewmodels.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.findFragmentById(R.id.activity_main_nav_host_fragment) as NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.bottom_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setupWithNavController(navController)
        val model = ViewModelProvider(this)[SharedViewModel::class.java]
        binding.viewModel = model
        binding.lifecycleOwner = this
    }
}
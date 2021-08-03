package com.example.sobes3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sobes3.view.AutorizationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView =
            findViewById<View>(R.id.bottom_navigation_bar) as BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.pictures -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container,PhotosFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.autorization -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container,
                        AutorizationFragment()
                    ).commit()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

    }
}
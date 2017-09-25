package com.mishkaowner.retrika.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mishkaowner.retrika.R

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, MainFragment()).commit()
    }
}

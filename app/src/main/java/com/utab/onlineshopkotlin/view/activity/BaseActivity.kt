package com.utab.onlineshopkotlin.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utab.onlineshopkotlin.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
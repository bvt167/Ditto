package edu.uw.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
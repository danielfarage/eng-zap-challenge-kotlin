package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.HomeActivity

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.farage.daniel.eng_zap_challenge_kotlin.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: AppCompatActivity() {

    private lateinit var zapButton: ImageButton
    private lateinit var vivaRealButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = resources.getColor(R.color.colorAccent)

        bindView()
    }

    private fun bindView() {
        zapButton = logoZap_imageView
        vivaRealButton = logoVivaReal_imageView
    }

}
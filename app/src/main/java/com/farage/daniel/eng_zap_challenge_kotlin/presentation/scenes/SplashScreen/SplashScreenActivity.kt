package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.SplashScreen

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import com.airbnb.lottie.LottieAnimationView
import com.farage.daniel.eng_zap_challenge_kotlin.R
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.HomeActivity.HomeActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var homeAnimation: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        bindViews()
        setupAnimatorListener()
    }

    private fun bindViews() {
        homeAnimation = homeAnimationView
    }

    private fun setupAnimatorListener() {
        homeAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator?) {
                startActivity(
                    Intent(this@SplashScreenActivity, HomeActivity::class.java)
                )
                finish()
            }

            override fun onAnimationRepeat(animation: Animator?) = Unit

            override fun onAnimationCancel(animation: Animator?) = Unit

            override fun onAnimationStart(animation: Animator?) = Unit

        })
    }
}

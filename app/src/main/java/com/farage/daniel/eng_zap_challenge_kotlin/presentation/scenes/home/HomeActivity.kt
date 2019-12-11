package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieAnimationView
import com.farage.daniel.eng_zap_challenge_kotlin.R
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.COMPANY_KEY
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.CompanyHolder
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.ScreenState
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentspannel.ApartmentsPannelActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception

class HomeActivity: AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var zapButton: ImageButton
    private lateinit var vivaRealButton: ImageButton
    private lateinit var loadingView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = resources.getColor(R.color.colorAccent)
        bindView()
        setupListeners()
        homeViewModel.loadApartments()
        observeState()
    }

    private fun observeState() {
        homeViewModel.apartmentsAdded.observe(this, Observer {
            when(it){
                is ScreenState.Loading -> showLoading()
                is ScreenState.Failure -> showError(it.error)
                is ScreenState.Success -> showSuccess()
            }
        })
    }

    private fun showLoading(){
        Snackbar.make(home_layout, "Carregando dados", Snackbar.LENGTH_SHORT).show()
        zapButton.isEnabled = false
        vivaRealButton.isEnabled = false
    }

    private fun showError(error: Exception) {
        loadingView.visibility = View.GONE
        Snackbar.make(home_layout, "Erro ao carregar dados", Snackbar.LENGTH_SHORT).show()
    }

    private fun showSuccess() {
        loadingView.visibility = View.GONE
        zapButton.isEnabled = true
        vivaRealButton.isEnabled = true
    }

    private fun bindView() {
        zapButton = logoZap_imageView
        vivaRealButton = logoVivaReal_imageView
        loadingView = loadingLottieView
    }

    private fun setupListeners() {
        zapButton.setOnClickListener {
            startActivity(intentForPannelActivity(CompanyHolder.ZAP))
            finish()
        }
        vivaRealButton.setOnClickListener {
            startActivity(intentForPannelActivity(CompanyHolder.VIVA_REAL))
            finish()
        }
    }

    private fun intentForPannelActivity(companyHolder: CompanyHolder): Intent {
        val companyBundle = Bundle()
            companyBundle.putSerializable(COMPANY_KEY, companyHolder)
        return Intent(
            this@HomeActivity,
            ApartmentsPannelActivity::class.java
        ).putExtras(companyBundle)
    }

}
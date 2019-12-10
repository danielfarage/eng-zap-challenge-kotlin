package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.home

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.farage.daniel.eng_zap_challenge_kotlin.R
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.COMPANY_KEY
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.CompanyHolder
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentspannel.ApartmentsPannelActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity: AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var zapButton: ImageButton
    private lateinit var vivaRealButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = resources.getColor(R.color.colorAccent)
        bindView()
        setupListeners()
        homeViewModel.loadApartments()
    }

    private fun bindView() {
        zapButton = logoZap_imageView
        vivaRealButton = logoVivaReal_imageView
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
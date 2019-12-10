package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentspannel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.farage.daniel.eng_zap_challenge_kotlin.R
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.Constants.COMPANY_KEY
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.CompanyHolder
import kotlinx.android.synthetic.main.activity_apartments_pannel.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ApartmentsPannelActivity: AppCompatActivity() {

    private lateinit var companyHolder: CompanyHolder
    private val apartmentsViewModel: ApartmentsPannelViewModel by viewModel()
    private val apartmentsAdapter = ApartmentsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apartments_pannel)
        companyHolder = intent.extras?.getSerializable(COMPANY_KEY) as CompanyHolder
        apartmentsViewModel.retriveAllApartments(companyHolder).observe(this, Observer {
            apartmentsAdapter.submitList(it)
        })
        apartmentsRecyclerView.layoutManager = LinearLayoutManager(this)
        apartmentsRecyclerView.adapter = apartmentsAdapter
    }

}
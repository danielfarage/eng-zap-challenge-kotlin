package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.farage.daniel.eng_zap_challenge_kotlin.R
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_apartment_details.view.*

class ApartmentDetailsFragment(private val apartment: Apartment): BottomSheetDialogFragment() {

    private lateinit var bottomSheet: View
    private lateinit var valueText:TextView
    private lateinit var closeButton: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_apartment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
        setupViews()
        setupListeners()
    }

    override fun getTheme(): Int {
        return R.style.Theme_MaterialComponents_Light_BottomSheetDialog
    }

    private fun bindViews(view:View) {
        bottomSheet = view.layout_bottom_sheet
        valueText = view.valueTextView
        closeButton = view.closeImageButton
    }

    private fun setupViews() {
        valueText.text = apartment.address.neighborhood
    }

    private fun setupListeners() {
        closeButton.setOnClickListener { this.dismiss() }
    }
}
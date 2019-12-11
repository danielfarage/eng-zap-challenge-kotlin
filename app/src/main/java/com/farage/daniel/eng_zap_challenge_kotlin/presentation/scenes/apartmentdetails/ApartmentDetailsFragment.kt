package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.farage.daniel.eng_zap_challenge_kotlin.R
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.toMoney
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_apartment_details.view.*

class ApartmentDetailsFragment(private val apartment: Apartment): BottomSheetDialogFragment() {

    private lateinit var bottomSheet: View
    private lateinit var bannerViewPager: ViewPager
    private lateinit var closeButton: ImageView
    private lateinit var businessTypeTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var locationTextView: TextView
    private lateinit var monthyCondoTextView: TextView
    private lateinit var bedroomsTextView: TextView
    private lateinit var bathroomsTextView: TextView
    private lateinit var parkingSpacesTextView: TextView

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
        closeButton = view.closeImageButton
        bannerViewPager = view.bannerViewPager
        businessTypeTextView = view.businessTypeTextView
        priceTextView = view.priceTextView
        locationTextView = view.locationTextView
        monthyCondoTextView = view.monthyCondoTextView
        bedroomsTextView = view.bedroomsTextView
        bathroomsTextView = view.bathroomsTextView
        parkingSpacesTextView = view.parkingSpacesTextView
    }

    private fun setupViews() {
        bannerViewPager.adapter = ApartmentsPagerAdapter(apartment.images)
        businessTypeTextView.text = "${apartment.pricingInfos.businessType} - ${apartment.usableAreas}m"
        priceTextView.text = apartment.pricingInfos.price.toMoney()
        locationTextView.text = "Localização: ${apartment.address.city} - ${apartment.address.neighborhood}"
        monthyCondoTextView.text = "Condomínio: ${apartment.pricingInfos.monthlyCondoFee.toMoney()}"
        bedroomsTextView.text = "Quartos: ${apartment.bedrooms}"
        bathroomsTextView.text = "Banheiros: ${apartment.bathrooms}"
        parkingSpacesTextView.text = "Vagas na garagem: ${apartment.parkingSpaces}"
    }

    private fun setupListeners() {
        closeButton.setOnClickListener { this.dismiss() }
    }
}
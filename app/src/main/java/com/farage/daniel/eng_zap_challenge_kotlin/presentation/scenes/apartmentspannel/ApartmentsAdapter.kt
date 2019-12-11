package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentspannel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.farage.daniel.eng_zap_challenge_kotlin.R
import com.farage.daniel.eng_zap_challenge_kotlin.domain.utils.toMoney
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.common.CompanyHolder
import com.farage.daniel.eng_zap_challenge_kotlin.presentation.model.Apartment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_apartment.view.*

class ApartmentsAdapter(private val clickListener: (apartment: Apartment) -> Unit
) : PagedListAdapter<Apartment, ApartmentsAdapter.ApartmentViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ApartmentViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, clickListener) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_apartment, parent, false)
        return ApartmentViewHolder(view)
    }

    class ApartmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImageView = itemView.item_image
        private val negociacaoMetragemTextView = itemView.item_negociacao_metragem
        private val cidadeBairoTextView = itemView.item_cidade_bairro
        private val valorTextView = itemView.item_valor
        fun bind(apartment: Apartment, clickListener: (apartment: Apartment) -> Unit) {
            itemView.setOnClickListener { clickListener(apartment) }
            with(apartment) {
                cidadeBairoTextView.text = "${address.city} - ${address.neighborhood}"
                negociacaoMetragemTextView.text = "${pricingInfos.businessType} - ${usableAreas}m"
                valorTextView.text = pricingInfos.price.toMoney()

                Picasso.get()
                    .load(images.first())
                    .error(R.drawable.ic_error_outline)
                    .placeholder(R.drawable.loading)
                    .into(itemImageView)
            }
        }
    }
}


private class DiffCallback : DiffUtil.ItemCallback<Apartment>() {

    override fun areItemsTheSame(oldItem: Apartment, newItem: Apartment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Apartment, newItem: Apartment): Boolean {
        return oldItem == newItem
    }

}
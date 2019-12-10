package com.farage.daniel.eng_zap_challenge_kotlin.presentation.scenes.apartmentspannel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.farage.daniel.eng_zap_challenge_kotlin.R
import com.farage.daniel.eng_zap_challenge_kotlin.data.model.entities.ApartmentEntity
import kotlinx.android.synthetic.main.item_apartment.view.*

class ApartmentsAdapter: PagedListAdapter<ApartmentEntity, ApartmentsAdapter.ApartmentViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ApartmentViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_apartment, parent, false)
        return ApartmentViewHolder(view)
    }

    class ApartmentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title = itemView.textView2
        fun bind(apartmentEntity: ApartmentEntity) {
            with(apartmentEntity) {
                title.text = id
            }
        }
    }
    }

    private class DiffCallback : DiffUtil.ItemCallback<ApartmentEntity>() {

        override fun areItemsTheSame(oldItem: ApartmentEntity, newItem: ApartmentEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ApartmentEntity, newItem: ApartmentEntity): Boolean {
            return oldItem == newItem
        }

}
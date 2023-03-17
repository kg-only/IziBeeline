package com.example.izibeeline.ui.store.tariffs.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.izibeeline.databinding.AvailableTariffsItemBinding
import com.example.izibeeline.ui.store.tariffs.TestModel

class AvailableTariffsAdapter :
    ListAdapter<TestModel, AvailableTariffsAdapter.AdminKKMVH>(diffCallback) {

    private var onItemClick: ((item: TestModel) -> Unit)? = null
    fun setOnItemClick(listener: (item: TestModel) -> Unit) {
        onItemClick = listener
    }

    inner class AdminKKMVH(private val itemBinding: AvailableTariffsItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(item: TestModel) = with(itemBinding) {
            img.setImageResource(item.img!!)
            mainText.text = item.textTitle
            descriptionText.text = item.textDescription
            itemView.setOnClickListener { onItemClick?.invoke(item) }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<TestModel>() {
            override fun areItemsTheSame(oldItem: TestModel, newItem: TestModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TestModel, newItem: TestModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminKKMVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AvailableTariffsItemBinding.inflate(layoutInflater, parent, false)
        return AdminKKMVH(binding)
    }

    override fun onBindViewHolder(holder: AdminKKMVH, position: Int) =
        holder.bind(getItem(position))
}
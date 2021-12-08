package com.example.voterinformation.ui.home

import android.R
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.voterinformation.data.models.LocalRepsByAddress
import com.example.voterinformation.databinding.RepsByAddressListBinding
import com.example.voterinformation.utility.bindImage
import javax.inject.Inject


class OfficialListAdapter @Inject constructor(val clickListener: ClickListener) :
    ListAdapter<LocalRepsByAddress, OfficialListAdapter.ViewHolder>(OfficialListDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: RepsByAddressListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LocalRepsByAddress, clickListener: ClickListener) {
            binding.executePendingBindings()
            binding.data = item
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RepsByAddressListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class OfficialListDiffCallback : DiffUtil.ItemCallback<LocalRepsByAddress>() {

    override fun areItemsTheSame(
        oldItem: LocalRepsByAddress,
        newItem: LocalRepsByAddress
    ): Boolean {
        return oldItem.nameKey == newItem.nameKey
    }

    override fun areContentsTheSame(
        oldItem: LocalRepsByAddress,
        newItem: LocalRepsByAddress
    ): Boolean {
        return oldItem == newItem
    }
}

class ClickListener @Inject constructor() {

    var onItemClick: ((LocalRepsByAddress) -> Unit)? = null

    fun onClick(data: LocalRepsByAddress) {
        Log.d("nameKey", data.nameKey)
        Log.d("photoUrlClick", data.official.photoUrl)
        onItemClick?.invoke(data)
    }
}
package com.example.voterinformation.utility

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.voterinformation.R
import javax.inject.Inject

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        if (!imgUrl.equals("None")) {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_home_black_24dp)
                        .error(R.drawable.ic_dashboard_black_24dp)
                )
                .centerCrop()
                .into(imgView)
        } else {
            Glide.with(imgView.context)
                .load(R.drawable.ic_user_solid)
                .centerCrop()
                .into(imgView)
        }
    }
}
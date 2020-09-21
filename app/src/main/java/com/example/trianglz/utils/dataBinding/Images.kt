package com.example.trianglz.utils.dataBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Glide.with(view.context)
        .load(imageUrl)
        .into(view)
}

@BindingAdapter("loaderStatus")
fun showAnimation(view: LottieAnimationView, isPlay: MutableLiveData<Boolean>) {
    isPlay.observeForever {
        if (it) {
            view.playAnimation()
        } else {
            view.pauseAnimation()
        }
    }

}
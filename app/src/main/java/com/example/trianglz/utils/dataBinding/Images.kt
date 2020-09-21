package com.example.trianglz.utils.dataBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Glide.with(view.context)
        .load(imageUrl)
        .apply(requestOptions)
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
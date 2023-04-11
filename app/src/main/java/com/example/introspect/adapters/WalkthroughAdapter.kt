package com.example.introspect.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieDrawable
import com.example.introspect.R
import com.example.introspect.data.local_models.WalkthroughModel
import com.example.introspect.databinding.WalkthroughItemBinding



class WalkthroughAdapter( val dataList:List<WalkthroughModel>) : RecyclerView.Adapter<WalkthroughAdapter.WalkThroughHolder>() {



    inner class WalkThroughHolder( val binding: WalkthroughItemBinding):RecyclerView.ViewHolder(binding.root){
 }



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalkThroughHolder {

        return  WalkThroughHolder(WalkthroughItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: WalkThroughHolder, position: Int) {
        holder.binding.apply {
            val paymentBean: WalkthroughModel = dataList[position]

            tvHeading.text = paymentBean.head
            tvDescription.text = paymentBean.desc
            image.repeatCount = LottieDrawable.INFINITE
            image.playAnimation()

            if(position ==1){
                image.setAnimation(R.raw.bikeriding)
            }else{
                image.setAnimation(R.raw.flower)
            }
        }





    }

    override fun getItemCount(): Int {
        return  dataList.size

    }
}
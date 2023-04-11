package com.example.introspect.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.introspect.R
import com.example.introspect.data.local_models.Progress
import com.example.introspect.databinding.ItemProgressBinding
import com.example.introspect.databinding.WalkthroughItemBinding

class ProgressAdapter(val progress:List<Progress>):RecyclerView.Adapter<ProgressAdapter.ViewHolder>() {

    var onItemClick: ((Progress) -> Unit)? = null

    inner class ViewHolder(val binding:ItemProgressBinding):RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(progress[adapterPosition])
            }
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(ItemProgressBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myProgress = progress[position]
        holder.binding.apply {

            when(myProgress){
                progress.first() ->{

                    ivIcon.setImageResource(R.drawable.circle_dot_svgrepo_com)
                }

                progress.last() ->{
                    roadmap.visibility = View.GONE
                    ivIcon.setImageResource(R.drawable.circle_dot_svgrepo_com)
                }
                else ->{
                    ivIcon.setImageResource(R.drawable.shape_circle_svgrepo_com)
                }

            }

            name.text = myProgress.name




        }
    }

    override fun getItemCount(): Int = progress.size
}
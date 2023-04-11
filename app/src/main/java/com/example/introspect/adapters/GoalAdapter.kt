package com.example.introspect.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.introspect.data.local_models.Goal
import com.example.introspect.data.local_models.WalkthroughModel
import com.example.introspect.databinding.ItemGoalBinding
import com.example.introspect.databinding.WalkthroughItemBinding

class GoalAdapter (val goals: List<Goal>): RecyclerView.Adapter<GoalAdapter.ViewHolder>() {

    inner class ViewHolder(val binding:ItemGoalBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(ItemGoalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val goal = goals[position]

            tvProgress.text =" ${goal.progressValue}% progress"
            tvHeading.text = goal.name
            tvDescription.text = goal.description}

    }

    override fun getItemCount(): Int = goals.size
}




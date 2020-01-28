package com.runeanim.mytoyproject.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.runeanim.mytoyproject.data.model.Contribute
import com.runeanim.mytoyproject.databinding.ContributeItemBinding

class ContributeAdapter :
    ListAdapter<Contribute, ContributeAdapter.ViewHolder>(
        TaskDiffCallback()
    ) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ContributeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Contribute) {
            binding.item = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ContributeItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class TaskDiffCallback : DiffUtil.ItemCallback<Contribute>() {
    override fun areItemsTheSame(oldItem: Contribute, newItem: Contribute): Boolean {
        return oldItem.data == newItem.data
    }

    override fun areContentsTheSame(oldItem: Contribute, newItem: Contribute): Boolean {
        return oldItem == newItem
    }
}

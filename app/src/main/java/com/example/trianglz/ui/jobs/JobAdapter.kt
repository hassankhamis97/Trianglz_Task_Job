package com.example.trianglz.ui.jobs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.trianglz.R
import com.example.trianglz.data.jobs.Job
import com.example.trianglz.databinding.JobItemBinding

class JobAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var jobs: List<Job>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return JobViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.job_item, parent, false
        ))

    }

    override fun getItemCount(): Int {
       return if (this::jobs.isInitialized) jobs.size else 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is JobViewHolder){
            holder.bind(jobs[position])
        }
    }
    inner class JobViewHolder(private var binding: JobItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Job){
            binding.apply {
                job = item
                executePendingBindings()
            }
        }
    }
    companion object {
        @JvmStatic
        @BindingAdapter("jobs")
        fun RecyclerView.bindItems(items: MutableLiveData<List<Job>>?) {
            val adapter = adapter as JobAdapter
            items?.observeForever {
                adapter.jobs = it.toList()
                adapter.notifyDataSetChanged()
            }
        }
    }
}
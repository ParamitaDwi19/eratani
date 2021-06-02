package com.capstone.eratani.monitor

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.capstone.eratani.R
import com.capstone.eratani.databinding.ItemMonitorBinding
import com.capstone.eratani.detail.monitor.DetailMonitorActivity
import com.capstone.eratani.model.ModelEntity

class MonitorAdapter : RecyclerView.Adapter<MonitorAdapter.MonitorViewHolder>() {
    private var listMovies = ArrayList<ModelEntity>()

    fun setMonitor(movies: List<ModelEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonitorViewHolder {
        val itemsMovieBinding = ItemMonitorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonitorViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MonitorViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size

    class MonitorViewHolder(private val binding: ItemMonitorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(monitor: ModelEntity) {
            with(binding) {
                tvItemName.text = monitor.name
                tvItemAlamat.text = monitor.alamat
                tvItemTemp.text = monitor.temp
                tvItemHumid.text = monitor.humid
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMonitorActivity::class.java)
//                    intent.putExtra(DetailMonitorActivity.EXTRA_DATA, movie.id)
//                    intent.putExtra(DetailMonitorActivity.EXTRA_MOVIE, true)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}
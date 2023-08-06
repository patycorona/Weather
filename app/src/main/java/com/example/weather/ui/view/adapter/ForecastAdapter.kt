package com.example.weather.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.BR
import com.example.weather.data.model.response.ForecastResponse
import com.example.weather.databinding.ItemWeatherBinding

class ForecastAdapter(private val listener: OnClickListener):
    ListAdapter<ForecastResponse, RecyclerView.ViewHolder>(ForecastDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent,
            false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val forecast = getItem(position)

        with(holder as ViewHolder){
            holder.binding?.setVariable(BR.forecast, forecast)
            holder.binding?.executePendingBindings()

            setListener(forecast)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ItemWeatherBinding>(view)

        fun setListener(forecast: ForecastResponse) {
            binding?.root?.setOnClickListener {
                listener.onClick(forecast)
            }
        }
    }

    class ForecastDiffCallback : DiffUtil.ItemCallback<ForecastResponse>() {
        override fun areItemsTheSame(oldItem: ForecastResponse, newItem: ForecastResponse): Boolean =
            oldItem.dt == newItem.dt

        override fun areContentsTheSame(oldItem: ForecastResponse, newItem: ForecastResponse): Boolean =
            oldItem == newItem
    }

}


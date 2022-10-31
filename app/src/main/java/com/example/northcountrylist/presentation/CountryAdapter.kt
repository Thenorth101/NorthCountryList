package com.example.northcountrylist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.northcountrylist.R
import com.example.northcountrylist.model.Country


class CountryAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val region: TextView

        init {
            name = view.findViewById(R.id.countryName)
            region = view.findViewById(R.id.countryRegion)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_country, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text = countries[position].name
        viewHolder.region.text = countries[position].region
    }

    override fun getItemCount() = countries.size

}


package com.example.northcountrylist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.northcountrylist.data.response.Country
import com.example.northcountrylist.databinding.ItemCountryBinding


class CountryAdapter(private val countries: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root){
        var countryName: TextView = binding.countryName
        var countryCapital: TextView = binding.countryCapital
        var countryRegion: TextView = binding.countryRegion
        var countryLanguage: TextView = binding.countryLanguage
        var countryCurrency: TextView = binding.countryCurrency
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder){
            with(countries[position]){
                countryName.text = this.name
                countryCapital.text = this.capital
                countryRegion.text = this.region
                countryLanguage.text = this.language
                countryCurrency.text = this.currency
            }
        }
    }

    override fun getItemCount() = countries.size

}


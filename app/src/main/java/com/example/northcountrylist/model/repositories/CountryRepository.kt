package com.example.northcountrylist.model.repositories

import com.example.northcountrylist.data.request.CountryApi
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val api: CountryApi
) {

    suspend fun getCountries() = api.getCountries()
}
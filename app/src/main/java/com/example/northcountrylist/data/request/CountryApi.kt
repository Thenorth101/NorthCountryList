package com.example.northcountrylist.data.request

import com.example.northcountrylist.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {

    @GET("https://thenorth101.github.io/northcountryapi/country_list.json")
    suspend fun getCountries(): Response<List<Country>>
}
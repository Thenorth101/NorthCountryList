package com.example.northcountrylist.data.request

import com.example.northcountrylist.data.response.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {

    @GET("country_list.json")
    suspend fun getCountries(): Response<List<Country>>
}
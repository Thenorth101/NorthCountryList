package com.example.northcountrylist.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.northcountrylist.data.response.Country
import com.example.northcountrylist.model.repositories.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: CountryRepository): ViewModel() {

    val _country = MutableLiveData<List<Country>>()
    val country: LiveData<List<Country>>
    get() = _country

    init {
        getCountries()
    }

    private fun getCountries()=viewModelScope.launch {
        repository.getCountries().let { response ->
            if(response.isSuccessful){
                _country.postValue(response.body())
            } else {
                Log.e("MainActivityViewModel", "Response was not successful")
            }
        }
    }
}
package com.example.northcountrylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.northcountrylist.databinding.ActivityMainBinding
import com.example.northcountrylist.presentation.CountryAdapter
import com.example.northcountrylist.presentation.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CountryAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.country.observe(this, Observer { response ->
            binding.mainActivityRecyclerView.layoutManager = LinearLayoutManager(this)
            adapter = CountryAdapter(response)

            binding.mainActivityRecyclerView.adapter = adapter
        })
    }
}
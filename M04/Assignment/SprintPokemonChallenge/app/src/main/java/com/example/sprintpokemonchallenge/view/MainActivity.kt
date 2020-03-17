package com.example.sprintpokemonchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sprintpokemonchallenge.R
import com.example.sprintpokemonchallenge.databinding.ActivityMainBinding
import com.example.sprintpokemonchallenge.recyclerAdapter.RecyclerAdapter
import com.example.sprintpokemonchallenge.viewmodel.MainViewModel
import com.example.sprintpokemonchallenge.viewmodel.MainViewModel.Companion.searchedPokemon
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.recycler

class MainActivity : AppCompatActivity() {
    val editText: EditText = edit_txt
    val main = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = MainViewModel()
        binding.executePendingBindings()
    }

    override fun onResume() {
        recycler.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler.layoutManager = manager
        val adapter = RecyclerAdapter(searchedPokemon)
        recycler.adapter = adapter
        super.onResume()
    }
}
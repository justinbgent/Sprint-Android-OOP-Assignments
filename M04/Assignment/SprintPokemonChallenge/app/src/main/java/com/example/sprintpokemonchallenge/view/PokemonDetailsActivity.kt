package com.example.sprintpokemonchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sprintpokemonchallenge.R
import com.example.sprintpokemonchallenge.databinding.ActivityPokemonDetailsBinding
import com.example.sprintpokemonchallenge.viewmodel.PokemonDetailsViewModel
import kotlinx.android.synthetic.main.activity_pokemon_details.*

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val binding = DataBindingUtil.setContentView<ActivityPokemonDetailsBinding>(this, R.layout.activity_pokemon_details)
        binding.detailViewModel = PokemonDetailsViewModel()
        binding.detailViewModel.getUI(image_sprite, txt_pokemon_name, txt_id, txt_abilities, txt_types)
        binding.executePendingBindings()
    }
}

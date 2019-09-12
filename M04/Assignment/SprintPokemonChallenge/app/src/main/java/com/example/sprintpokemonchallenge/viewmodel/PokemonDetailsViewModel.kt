package com.example.sprintpokemonchallenge.viewmodel

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BaseObservable
import com.example.sprintpokemonchallenge.viewmodel.MainViewModel.Companion.pokemonInfo
import com.squareup.picasso.Picasso

class PokemonDetailsViewModel: BaseObservable() {

    fun getUI(image_sprite: ImageView,
              txt_pokemon_name: TextView,
              txt_id: TextView,
              txt_abilities: TextView,
              txt_types: TextView
    ){

        Picasso.get().load(pokemonInfo.sprites.pokemonSprite).into(image_sprite)
        txt_pokemon_name.text = pokemonInfo.name
        txt_id.text = pokemonInfo.id.toString()

        pokemonInfo.sprites
        pokemonInfo.types

        var abilities = ""
        for (i in pokemonInfo.abilities.indices){
            abilities += "-${pokemonInfo.abilities[i].ability.name} "
        }
        txt_abilities.text = abilities


        var types = ""
        for (i in pokemonInfo.types.indices){
            types += "-${pokemonInfo.types[i].type.name} "
        }
        txt_types.text = types
    }

}
package com.example.sprintpokemonchallenge.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.EditText
import androidx.databinding.BaseObservable
import com.example.sprintpokemonchallenge.model.PokemonDetail
import com.example.sprintpokemonchallenge.retrofit.RetrofitInstance
import com.example.sprintpokemonchallenge.view.PokemonDetailsActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: BaseObservable() {

    companion object {
        lateinit var pokemonInfo: PokemonDetail
        var searchedPokemon: ArrayList<PokemonDetail> = arrayListOf()
    }

    fun onClickSearch(editTxt: EditText, context: Context){
        RetrofitInstance.getPokemon(editTxt.text.toString().toLowerCase()).enqueue(object:
            Callback<PokemonDetail> {
            override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
            }

            override fun onResponse(call: Call<PokemonDetail>, response: Response<PokemonDetail>) {
                if (response.body() != null){
                    pokemonInfo = response.body() as PokemonDetail

                    var addPokemonToList = true
                    if (searchedPokemon.size < 1){
                        searchedPokemon.add(pokemonInfo)
                        addPokemonToList = false
                    }
                    else {
                        for (i in searchedPokemon.indices){
                            if(searchedPokemon[i] == pokemonInfo){
                                addPokemonToList = false
                                break
                            }
                        }
                    }
                    if (addPokemonToList){
                        searchedPokemon.add(pokemonInfo)
                    }

                    val intent = Intent(context, PokemonDetailsActivity::class.java)
                    context.startActivity(intent)
                }
            }
        })
    }
}
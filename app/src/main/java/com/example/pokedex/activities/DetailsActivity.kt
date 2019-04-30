package com.example.pokedex.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.example.pokedex.R
import com.example.pokedex.fragments.LandPokemonContent
import com.example.pokedex.models.Pokemon

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        var pokemonInfo: Pokemon = intent?.extras?.getParcelable("Pokemon") ?: Pokemon()

        initActivity(pokemonInfo)
    }

    fun initActivity(pokemon: Pokemon) {
        Log.d("Inicio DetailsActivity","Inicio de initActivity")
        var contentFragmet: LandPokemonContent = LandPokemonContent.newInstance(pokemon)
        changeFragment(R.id.content, contentFragmet)


    }

    private fun changeFragment(id: Int, frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, frag).commit()
    }

}

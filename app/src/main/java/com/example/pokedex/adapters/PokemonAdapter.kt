package com.example.pokedex.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.models.Pokemon
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class PokemonAdapter(val items: List<Pokemon>, val clickListener: (Pokemon) -> Unit) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {


    var url: String = ""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_list_item, parent, false)


        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, count: Int) {
        holder.bind(items[count], clickListener)


        url = items[count].url

        var countUno: Int = count + 1

        Glide.with(holder.itemView.context)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$countUno.png")
            .into(holder.itemView.pokemon_icon)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Pokemon, clickListener: (Pokemon) -> Unit) = with(itemView) {
            pokemon_name.text =item.name
            this.setOnClickListener { clickListener(item)
            }

        }

    }
}
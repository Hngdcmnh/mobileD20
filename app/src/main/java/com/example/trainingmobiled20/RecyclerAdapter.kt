package com.example.trainingmobiled20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var namePokemons = arrayOf(
        "Bulbasaur",
        "Ivysaur",
        "Venusaur",
        "Charmander",
        "Charmeleon",
        "Charizard",
        "Squirtle",
        "Wartortle",
        "Blastoise",
        "Caterpie",
        "Metapod",
        "Butterfree",
        "Weedle",
        "Kakuna",
        "Beedrill"
    )
    private var typePokemons = arrayOf(
        "Grass, Poison",
        "Grass, Poison",
        "Grass, Poison",
        "Fire",
        "Fire",
        "Fire, Flying",
        "Water",
        "Water",
        "Water",
        "Bug",
        "Bug",
        "Bug, Flying",
        "Bug, Poison",
        "Bug, Poison",
        "Bug, Poison"
    )
    private var speciesPokemons = arrayOf(
        "Seed Pokémon",
        "Seed Pokémon",
        "Seed Pokémon",
        "Lizard Pokémon",
        "Flame Pokémon",
        "Flame Pokémon",
        "Tiny Turtle Pokémon",
        "Turtle Pokémon",
        "Shellfish Pokémon",
        "Worm Pokémon",
        "Cocoon Pokémon",
        "Butterfly Pokémon",
        "Hairy Bug Pokémon",
        "Cocoon Pokémon",
        "Poison Bee Pokémon"
    )
    private var imagePokemons = intArrayOf(
        R.drawable.bulbasaur,
        R.drawable.ivysaur,
        R.drawable.venusaur,
        R.drawable.charmander,
        R.drawable.charmeleon,
        R.drawable.charizard,
        R.drawable.squirtle,
        R.drawable.wartortle,
        R.drawable.blastoise,
        R.drawable.caterpie,
        R.drawable.metapod,
        R.drawable.butterfree,
        R.drawable.weedle,
        R.drawable.kakuna,
        R.drawable.beedrill
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.namePokemon.text = namePokemons[position]
        holder.typePokemon.text = typePokemons[position]
        holder.speciedPokemon.text=speciesPokemons[position]
        holder.imagePokemon.setImageResource(imagePokemons[position])
    }

    override fun getItemCount(): Int {
        return namePokemons.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagePokemon: ImageView = itemView.findViewById(R.id.imagePokemon)
        var typePokemon: TextView = itemView.findViewById(R.id.typePokemon)
        var namePokemon: TextView = itemView.findViewById(R.id.namePokemon)
        var speciedPokemon :TextView = itemView.findViewById(R.id.speciesPokemon)
        val button: Button = itemView.findViewById<Button>(R.id.btdetail)
        init {
            button.setOnClickListener{
                Toast.makeText(itemView.context,"Pokemon : ${namePokemon.text} \n Type : ${typePokemon.text}\n Species : ${speciedPokemon.text}",Toast.LENGTH_LONG).show()
            }
        }
    }
}
package com.example.trainingmobiled20

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingmobiled20.data.Pokemon
import com.example.trainingmobiled20.databinding.CardLayoutBinding

class RecyclerAdapter(private val pokemons: ArrayList<Pokemon>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.namePokemon.text = pokemon.name
        holder.typePokemon.text = pokemon.type
        holder.speciedPokemon.text = pokemon.species
        holder.imagePokemon.setImageResource(pokemon.image)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    class ViewHolder(private val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var imagePokemon: ImageView = binding.imagePokemon
        var typePokemon: TextView = binding.typePokemon
        var namePokemon: TextView = binding.namePokemon
        var speciedPokemon: TextView = binding.speciesPokemon
        val button: Button

        init {
            button = binding.btdetail
            button.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "Pokemon : ${namePokemon.text} \n Type : ${typePokemon.text}\n Species : ${speciedPokemon.text}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
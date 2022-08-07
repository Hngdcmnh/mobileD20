package com.example.trainingmobiled20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingmobiled20.data.Pokemon

class RecyclerAdapter(private val pokemons: ArrayList<Pokemon>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.namePokemon.text = pokemon.name
        holder.typePokemon.text = pokemon.type
        holder.speciedPokemon.text = pokemon.species
        holder.imagePokemon.setImageResource(pokemon.image)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagePokemon: ImageView = itemView.findViewById(R.id.imagePokemon)
        var typePokemon: TextView = itemView.findViewById(R.id.typePokemon)
        var namePokemon: TextView = itemView.findViewById(R.id.namePokemon)
        var speciedPokemon: TextView = itemView.findViewById(R.id.speciesPokemon)
        val button: Button = itemView.findViewById<Button>(R.id.btdetail)

        init {
            button.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "Pokemon : ${namePokemon.text} \n Type : ${typePokemon.text}\n Species : ${speciedPokemon.text}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
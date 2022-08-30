package com.example.trainingmobiled20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingmobiled20.data.*
import com.example.trainingmobiled20.databinding.FragmentPokemonWikiBinding

class PokemonWikiFragment : Fragment(R.layout.fragment_pokemon_wiki) {
    private lateinit var binding: FragmentPokemonWikiBinding
    private lateinit var pokemons: ArrayList<Pokemon>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonWikiBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        val adapter = RecyclerAdapter(pokemons)
        recyclerView.adapter = adapter
    }

    private fun dataInit() {
        pokemons = arrayListOf<Pokemon>()
        pokemons.add(Bulbasaur())
        pokemons.add(Ivysaur())
        pokemons.add(Venusaur())
        pokemons.add(Charmander())
        pokemons.add(Charmeleon())
        pokemons.add(Charizard())
        pokemons.add(Squirtle())
        pokemons.add(Wartortle())
        pokemons.add(Blastoise())
        pokemons.add(Caterpie())
        pokemons.add(Metapod())
        pokemons.add(Butterfree())
        pokemons.add(Weedle())
        pokemons.add(Kakuna())
        pokemons.add(Beedrill())
        pokemons.add(Pidgey())
        pokemons.add(Pidgeotto())
        pokemons.add(Pidgeot())
        pokemons.add(Rattata())
        pokemons.add(Raticate())
        pokemons.add(Spearow())
        pokemons.add(Fearow())
        pokemons.add(Ekans())
        pokemons.add(Arbok())
        pokemons.add(Pikachu())
        pokemons.add(Raichu())
        pokemons.add(Sandshrew())
        pokemons.add(Sandslash())
    }
}
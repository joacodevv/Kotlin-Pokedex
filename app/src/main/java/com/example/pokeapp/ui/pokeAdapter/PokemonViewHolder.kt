package com.example.pokeapp.ui.pokeAdapter


import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.data.PokeModel
import com.example.pokeapp.R
import com.example.pokeapp.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso

class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(pokemon: PokeModel, onItemSelected: (String) -> Unit) {
        binding.tvPokemonName.text = pokemon.name
        Picasso.get().load(pokemon.sprites.frontDefault).into(binding.ivPokemon)
        binding.tvPokemonID.text = pokemon.id.toString()
        binding.root.setOnClickListener { onItemSelected(pokemon.name) }
        when (pokemon.types[0].type.name) {
            "normal" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.normal
                    )
                )
            }

            "fighting" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.fighting
                    )
                )
            }

            "flying" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.flying
                    )
                )
            }

            "poison" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.poison
                    )
                )
            }

            "ground" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.ground
                    )
                )
            }

            "rock" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.rock
                    )
                )
            }

            "bug" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.bug
                    )
                )
            }

            "ghost" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.ghost
                    )
                )
            }

            "steel" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.steel
                    )
                )
            }

            "fire" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.fire
                    )
                )
            }

            "water" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.water
                    )
                )
            }

            "grass" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.grass
                    )
                )
            }

            "electric" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.electric
                    )
                )
            }

            "psychic" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.psychic
                    )
                )
            }

            "ice" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.ice
                    )
                )
            }

            "dragon" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.dragon
                    )
                )
            }

            "dark" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.dark
                    )
                )
            }

            "fairy" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.fairy
                    )
                )
            }

            "stellar" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.stellar
                    )
                )
            }

            "unknown" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.unknown
                    )
                )
            }
        }
    }
}
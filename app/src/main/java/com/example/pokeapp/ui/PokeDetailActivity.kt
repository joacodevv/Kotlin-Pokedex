package com.example.pokeapp.ui

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.pokeapp.R
import com.example.pokeapp.data.PokeModel
import com.example.pokeapp.data.StatModel
import com.example.pokeapp.data.api.ApiClient
import com.example.pokeapp.databinding.ActivityPokeDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class PokeDetailActivity : AppCompatActivity() {

    companion object {
        const val POKEMON_NAME = "pokemon_name"
    }

    private lateinit var binding: ActivityPokeDetailBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        retrofit = getRetrofit()
        val name: String = intent.getStringExtra(POKEMON_NAME).orEmpty()
        binding = ActivityPokeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPokemonInfo(name)
        goBack()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun goBack() {
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun getPokemonInfo(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<PokeModel> =
                retrofit.create(ApiClient::class.java).getPokemonInfo(name)
            if (call.isSuccessful) {
                val response: PokeModel? = call.body()
                if (response != null) {
                    runOnUiThread {
                        createUI(response)
                    }
                }
            }
        }
    }

    private fun createUI(response: PokeModel) {
        binding.tvPokemonId.text = response.id.toString()
        Picasso.get().load(response.sprites.frontDefault).into(binding.ivPokemon)
        binding.tvPokemonName.text = response.name
        if (response.types.size == 1) {
            binding.tvPokemonType1.text = response.types[0].type.name
            binding.pokemonCardType2.isVisible = false
        } else {
            binding.tvPokemonType1.text = response.types[0].type.name
            binding.tvPokemonType2.text = response.types[1].type.name
        }
        prepareStats(response.stats)
        prepareBackgroundMainType(response.types[0].type.name)
        if (response.types.size == 2) {
            prepareBackgroundSecondaryType(response.types[1].type.name)
        }
    }

    private fun prepareBackgroundSecondaryType(name: String) {
        when (name) {
            "normal" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.normal
                    )
                )
            }

            "fighting" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.fighting
                    )
                )
            }

            "flying" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.flying
                    )
                )
            }

            "poison" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.poison
                    )
                )
            }

            "ground" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.ground
                    )
                )
            }

            "rock" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.rock
                    )
                )
            }

            "bug" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.bug
                    )
                )
            }

            "ghost" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.ghost
                    )
                )
            }

            "steel" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.steel
                    )
                )
            }

            "fire" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.fire
                    )
                )
            }

            "water" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.water
                    )
                )
            }

            "grass" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.grass
                    )
                )
            }

            "electric" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.electric
                    )
                )
            }

            "psychic" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.psychic
                    )
                )
            }

            "ice" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.ice
                    )
                )
            }

            "dragon" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.dragon
                    )
                )
            }

            "dark" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.dark
                    )
                )
            }

            "fairy" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.fairy
                    )
                )
            }

            "stellar" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.stellar
                    )
                )
            }

            "unknown" -> {
                binding.pokemonCardType2.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.unknown
                    )
                )
            }
        }
    }

    private fun prepareBackgroundMainType(name: String) {
        when (name) {
            "normal" -> {
                binding.pokemonCard.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.normal
                    )
                )
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
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
                binding.pokemonCardType1.setCardBackgroundColor(
                    ContextCompat.getColor(
                        binding.pokemonCard.context,
                        R.color.unknown
                    )
                )
            }
        }
    }

    private fun prepareStats(stats: List<StatModel>) {
        updateHeight(binding.viewHp, stats[0].baseStat)
        updateHeight(binding.viewAttack, stats[1].baseStat)
        updateHeight(binding.viewDefense, stats[2].baseStat)
        updateHeight(binding.viewSpAttack, stats[3].baseStat)
        updateHeight(binding.viewSpDefense, stats[4].baseStat)
        updateHeight(binding.viewSpeed, stats[5].baseStat)
        binding.tvHp.text = stats[0].baseStat.toString()
        binding.tvAtk.text = stats[1].baseStat.toString()
        binding.tvDef.text = stats[2].baseStat.toString()
        binding.tvSpAtk.text = stats[3].baseStat.toString()
        binding.tvSpDef.text = stats[4].baseStat.toString()
        binding.tvSpd.text = stats[5].baseStat.toString()
    }

    private fun updateHeight(view: View, stat: Int) {
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            px,
            resources.displayMetrics
        )
            .roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
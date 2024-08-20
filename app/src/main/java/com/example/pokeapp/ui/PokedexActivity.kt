package com.example.pokeapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokeapp.data.AllPokemonModel
import com.example.pokeapp.data.api.ApiClient
import com.example.pokeapp.data.PokeModel
import com.example.pokeapp.R
import com.example.pokeapp.ui.PokeDetailActivity.Companion.POKEMON_NAME
import com.example.pokeapp.databinding.ActivityPokedexBinding
import com.example.pokeapp.ui.pokeAdapter.PokemonAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokedexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: PokemonAdapter
    private var pokemonList: MutableList<PokeModel> = emptyList<PokeModel>().toMutableList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()

        initUI()
        getAllPokemonBasicInfo()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUI() {
        adapter = PokemonAdapter{ pokemonName -> navigateToDetail(pokemonName) }
        binding.rvPokemon.adapter = adapter
        binding.rvPokemon.layoutManager = GridLayoutManager(this, 2)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getAllPokemonBasicInfo() {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<AllPokemonModel> =
                retrofit.create(ApiClient::class.java).getAllPokemon()
            if (call.isSuccessful) {
                val response: AllPokemonModel? = call.body()
                if (response != null) {
                    for (i in response.results.indices) {
                        val call2: Response<PokeModel> = retrofit.create(ApiClient::class.java)
                            .getAllPokemonBasicInfo(response.results[i].name)
                        pokemonList.add(call2.body()!!)
                    }
                    runOnUiThread {
                        binding.progressBar.isVisible = false
                        adapter.updateList(pokemonList)

                        //Log.i("Pokemon", response2.toString())
                    }
                }
            }
        }
    }

    private fun navigateToDetail(name:String){
        val intent = Intent(this, PokeDetailActivity::class.java)
        intent.putExtra(POKEMON_NAME, name)
        startActivity(intent)
    }


}
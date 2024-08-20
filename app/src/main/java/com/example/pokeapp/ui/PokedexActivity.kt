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
import com.example.pokeapp.data.GenerationModel
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

    companion object{
        const val GENERATION = "generation"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        goBack()
        initUI()
        val generation: String = intent.getStringExtra(GENERATION).orEmpty()
        getAllPokemonBasicInfo(generation)

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

    private fun getAllPokemonBasicInfo(generation: String) {
        binding.progressBar.isVisible = true

        when (generation){
            "GenerationI" -> { CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen1Pokemon()
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
            } }
            "GenerationII" -> { CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen2Pokemon()
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
            } }
            "GenerationIII" -> { CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen3Pokemon()
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
            } }
            "GenerationIV" -> {CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen4Pokemon()
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
            }}
            "GenerationV" -> {CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen5Pokemon()
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
            }}
            "GenerationVI" -> {CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen6Pokemon()
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
            }}
            "GenerationVII" -> {CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen7Pokemon()
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
            }}
            "GenerationVIII" -> {CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen8Pokemon()
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
            }}
            "GenerationIX" -> {CoroutineScope(Dispatchers.IO).launch {
                val call: Response<AllPokemonModel> =
                    retrofit.create(ApiClient::class.java).getAllGen9Pokemon()
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
            }}
        }
    }

    private fun navigateToDetail(name:String){
        val intent = Intent(this, PokeDetailActivity::class.java)
        intent.putExtra(POKEMON_NAME, name)
        startActivity(intent)
    }

    private fun goBack(){
        binding.backBtn.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }


}
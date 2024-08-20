package com.example.pokeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokeapp.data.GenerationInfo
import com.example.pokeapp.data.GenerationModel
import com.example.pokeapp.databinding.ActivityMainBinding
import com.example.pokeapp.genAdapter.GenerationAdapter
import com.example.pokeapp.ui.PokedexActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: GenerationAdapter

    var generationList: List<GenerationInfo> = listOf(
        GenerationInfo.GenerationI,
        GenerationInfo.GenerationII,
        GenerationInfo.GenerationIII,
        GenerationInfo.GenerationIV,
        GenerationInfo.GenerationV,
        GenerationInfo.GenerationVI,
        GenerationInfo.GenerationVII,
        GenerationInfo.GenerationVIII,
        GenerationInfo.GenerationIX
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.i("Generation", generationList.toString())
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUI() {
        adapter = GenerationAdapter(onItemSelected = {
            val type = when(it){
                GenerationInfo.GenerationI -> GenerationModel.GenerationI.toString()
                GenerationInfo.GenerationII -> GenerationModel.GenerationII.toString()
                GenerationInfo.GenerationIII -> GenerationModel.GenerationIII.toString()
                GenerationInfo.GenerationIV -> GenerationModel.GenerationIV.toString()
                GenerationInfo.GenerationV -> GenerationModel.GenerationV.toString()
                GenerationInfo.GenerationVI -> GenerationModel.GenerationVI.toString()
                GenerationInfo.GenerationVII -> GenerationModel.GenerationVII.toString()
                GenerationInfo.GenerationVIII -> GenerationModel.GenerationVIII.toString()
                GenerationInfo.GenerationIX -> GenerationModel.GenerationIX.toString()

            }
            navigateToPokedex(type)
        })
        binding.rvGenerations.adapter = adapter
        binding.rvGenerations.layoutManager = LinearLayoutManager(this)
    }

    private fun navigateToPokedex(generation: String){
        val intent = Intent(this, PokedexActivity::class.java)
        intent.putExtra(PokedexActivity.GENERATION, generation)
        startActivity(intent)
    }

}
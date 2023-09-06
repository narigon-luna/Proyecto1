package com.curso.proyecto1.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.curso.proyecto1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.resultado.observe(this) {
            binding.resultado.text = "${it.resul}"
        }

        binding.comparaBtn.setOnClickListener {
            val texto1: String = binding.texto1.text.toString()
            val texto2: String = binding.texto2.text.toString()
            mainViewModel.compararTexto(texto1, texto2)
        }
    }
}




























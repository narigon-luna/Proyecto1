package com.curso.proyecto1.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.proyecto1.model.Resultado
import kotlinx.coroutines.launch



class MainViewModel: ViewModel() {

    val resultado: LiveData<Resultado> get() = _resultado
    private var _resultado = MutableLiveData<Resultado>(Resultado(String(), String(), false))


    fun compararTexto(texto1: String, texto2: String) {


        if (texto1.isNotEmpty() && texto2.isNotEmpty()) {

            val result = texto1 == texto2
            updateResultado(texto1, texto2, result)

        } else if (texto1.isNotEmpty() && texto2.isNotEmpty()) {
            val result = texto1 != texto2
            updateResultado(texto1, texto2, result)
        }
    }
    private fun updateResultado(texto1: String, texto2: String, result: Boolean) {
        viewModelScope.launch {
            _resultado.value = Resultado(texto1, texto2, result)
        }
    }
}

package com.e.revendocoroutine34

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {

    //variavel lista que será uma MutableLiveData
    val listaFilmes = MutableLiveData<MutableList<Filme>>()

    //acessa a função getFilmes do Repository em uma coroutine lançada pelo viewModelScope
    fun getFilmesRepo() {
        //lança a coroutine
        viewModelScope.launch {
            try {
                //pega o retorno dafunção getFilmes() do Repository (temos instancia dele nos parametros)
               //o valor da listaFilmes será o retorno da getFilmes() do Repository
                listaFilmes.value = repository.getFilmes()
            } catch (e: Exception) {
                Log.e("MainViewModel", "Erro ao acessar repositorio")
            }
        }

    }


}
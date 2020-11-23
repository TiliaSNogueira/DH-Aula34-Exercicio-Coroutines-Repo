package com.e.revendocoroutine34

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//colocamos as coisas aqui pra ter o contexto aqui, e passamos o context pela função getFilmes
class MainViewModel(val repository: Repository, application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext

    //variavel lista que será uma MutableLiveData
    val listaFilmes = MutableLiveData<ArrayList<Filme>>()

    //acessa a função getFilmes do Repository em uma coroutine lançada pelo viewModelScope
    fun getFilmesRepo() {
        //lança a coroutine
        viewModelScope.launch {
            try {
                //pega o retorno dafunção getFilmes() do Repository (temos instancia dele nos parametros)
               //o valor da listaFilmes será o retorno da getFilmes() do Repository
                listaFilmes.value = repository.getFilmes(context)
            } catch (e: Exception) {
                Log.e("MainViewModel", "Erro ao acessar repositorio")
            }
        }

    }


}
package com.e.revendocoroutine34

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import java.io.IOException

//essa classe Repositiry acessa o servidor e retorna os dados
//implementar essas coisas


//tiramos aquelas coisas pq o repository não pode ser viewmodel
class Repository {

    //pega esse contexto atraves da função que é passada pela viewModel
    suspend fun getFilmes(context: Context): ArrayList<Filme> {

        //esse delay apenas simula o tempo de espera da requisição
       delay(5000)

        //aqui pegamos os filmes do  arquivo JSON
        var listaDeFilmes: ArrayList<Filme> = arrayListOf()

        try {

            //acessa o assets através do context, pega o arquivo, guarda espaço na memória e lê linha por linha
            val jsonString = context.assets.open("filmes.json")
                .bufferedReader().use { it.readText() }

            //pega o jsonString, e com o GSON diz no que essa "Stringona"  será transformada através do TypeToken
            listaDeFilmes =
                Gson().fromJson(jsonString, object : TypeToken<ArrayList<Filme>>() {}.type)

            return listaDeFilmes


        } catch (ioException: IOException) {
            Log.i("Repository", ioException.toString())
            //lista vai retornar vazia se não tiver entrado no try
            return listaDeFilmes

        }
    }


}
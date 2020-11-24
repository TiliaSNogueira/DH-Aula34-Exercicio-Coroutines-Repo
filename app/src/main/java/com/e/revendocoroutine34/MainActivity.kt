package com.e.revendocoroutine34

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity() {

    //instancia do Repository
    val repo = Repository()

    //instancia do MainViewModel passando o repo como parametro
    //obervar que é diferente pois ele precisa acessar o repo
    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repo, application) as T
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //NÃO PRECISA DESSAS COISAS
      //  var listaDeFilmes: ArrayList<Filme> = arrayListOf()
      //  var listaDeFilmes: ArrayList<Filme> = arrayListOf()

        //configurando o recycler view
        //   rv_main.adapter = adapterFilmes
      //  val adapterFilmes = FilmesAdapter(listaDeFilmes)

        viewModel.getFilmesRepo()

        //passar o adapter dentro do observavel
        viewModel.listaFilmes.observe(this, {
            rv_main.adapter = FilmesAdapter(it)
        })


        //configurando o recycler view
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.setHasFixedSize(true)


        //ASSIM PASSOU DE MANEIRA BEM MAIS SIMPLES, NA HORA DE CONFIGURAR O ADAPTER
        // JÁ PASSA ALISTA DIRETO NO OBSERVÁVEL

    }


}
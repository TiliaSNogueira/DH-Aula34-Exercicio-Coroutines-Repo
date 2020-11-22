package com.e.revendocoroutine34

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity () : AppCompatActivity() {

    //instancia do Repository
    val repo = Repository(application)

    //instancia do MainViewModel passando o repo como parametro
    //obervar que é diferente pois ele precisa acessar o repo
    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repo) as T
            }

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaDeFilmes: MutableList<Filme> = mutableListOf()

        val adapterFilmes = FilmesAdapter(listaDeFilmes)

        viewModel.getFilmesRepo()

        viewModel.listaFilmes.observe(this, {
            listaDeFilmes = it
        })


        //configurando o recycler view
        rv_main.adapter = adapterFilmes
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.setHasFixedSize(true)


    }


}
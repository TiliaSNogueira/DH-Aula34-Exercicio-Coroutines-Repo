package com.e.revendocoroutine34

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_filme.view.*

class FilmesAdapter(val listaDeFilmes: ArrayList<Filme>) :
    RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
        return FilmesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        val filme = listaDeFilmes[position]

        holder.tituloFilme.text = filme.titulo
        holder.dataFilme.text = filme.data
        holder.descricaoFilme.text = filme.descricao
        holder.direcaoFilme.text = filme.direcao

    }

    //não consegui usar o size como MutableLIveData
    override fun getItemCount() = listaDeFilmes.size

    //o nome dentro dos paramentros da FilmesViewHolder não precisa ser igual ao da view que criamos no onCreateView
    inner class FilmesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tituloFilme: TextView = itemView.tv_item_titulo_filme
        val dataFilme: TextView = itemView.tv_item_data
        val descricaoFilme: TextView = itemView.tv_item_descricao
        val direcaoFilme: TextView = itemView.tv_item_direcao

    }

}

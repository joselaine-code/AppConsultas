package br.com.joselaine.drconsulta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.joselaine.drconsulta.R
import br.com.joselaine.drconsulta.model.Especialidades

class EspecialidadeAdapter(private val especialidades: List<Especialidades>) :
    RecyclerView.Adapter<EspecialidadeAdapter.EspecialidadeViewHolder>() {

    inner class EspecialidadeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tituloEspecialidade)
        private val imagem = view.findViewById<ImageView>(R.id.imagemEspecialidade)
        fun bind(especialidades: Especialidades) {
            title.text = especialidades.nome
            imagem.setImageResource(especialidades.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EspecialidadeViewHolder {
        return EspecialidadeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_especialidade,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EspecialidadeViewHolder, position: Int) {
        holder.bind(especialidades[position])
    }

    override fun getItemCount() = especialidades.size
}
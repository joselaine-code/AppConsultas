package br.com.joselaine.drconsulta.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.joselaine.drconsulta.databinding.ProfissionalItemBinding
import br.com.joselaine.drconsulta.model.Profissional

class ProfissionalAdapter(
    private val listaProfissionais : List<Profissional>
) : RecyclerView.Adapter<ProfissionalAdapter.ProfissionalViewHolder>(){

    inner class ProfissionalViewHolder(private val binding: ProfissionalItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            profissional: Profissional
        ) {
            binding.nome.text = profissional.nome
            binding.especialidade.text = profissional.especialidade
            binding.avaliacao.text = profissional.avalicação.toString()
            if (profissional.avalicação <= 6.0){
                binding.avaliacao.setTextColor(Color.RED)
                binding.star.setColorFilter(Color.RED)
            }
            binding.ivFoto.setImageResource(profissional.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfissionalViewHolder {
        val binding = ProfissionalItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfissionalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfissionalViewHolder, position: Int) {
        holder.bind(listaProfissionais[position])
    }

    override fun getItemCount() = listaProfissionais.size
}
package br.com.joselaine.drconsulta.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.joselaine.drconsulta.R
import br.com.joselaine.drconsulta.adapter.ProfissionalAdapter
import br.com.joselaine.drconsulta.databinding.FragmentListaProfissionaisBinding
import br.com.joselaine.drconsulta.model.Profissional

class ListaProfissionaisFragment : Fragment() {

    private var binding: FragmentListaProfissionaisBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaProfissionaisBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listaProfissionais= listOf<Profissional>(
            Profissional("Leonard Crona", "Oftalmologista", R.drawable.doctor, 9.4),
            Profissional("Pedro Alberto", "Odontopediatria", R.drawable.dentista, 8.4),
            Profissional("Camila Bianco", "Psicologia Humanista", R.drawable.psicologo, 10.0),
            Profissional("Leandra Andrade", "Oftalmologista", R.drawable.doctor, 9.1),
            Profissional("Pedro Alberto", "Odontopediatria", R.drawable.dentista, 8.3),
            Profissional("Leandra Andrade", "Oftalmologista", R.drawable.doctor, 9.0),
            Profissional("Pedro Alberto", "Odontopediatria", R.drawable.dentista, 8.9),
            Profissional("Leandra Andrade", "Oftalmologista", R.drawable.doctor, 9.5),
            Profissional("Paula de Oliveira", "Nutróloga", R.drawable.nutri, 8.4),
            Profissional("Mandy D'Amore", "Psicologia Existencial", R.drawable.psicologo, 5.6)
        )
        val profissionaisAdapter = ProfissionalAdapter(listaProfissionais)
        binding?.let {
            with(it) {
                binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
                binding?.recyclerView?.adapter = profissionaisAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
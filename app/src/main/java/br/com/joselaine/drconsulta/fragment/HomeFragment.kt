package br.com.joselaine.drconsulta.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.joselaine.drconsulta.R
import br.com.joselaine.drconsulta.adapter.EspecialidadeAdapter
import br.com.joselaine.drconsulta.databinding.FragmentHomeBinding
import br.com.joselaine.drconsulta.model.Especialidades


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null


    private val especialidadeAdapter = EspecialidadeAdapter(
        listOf(
            Especialidades("Médico(a)", R.drawable.doctor),
            Especialidades("Nutricionista", R.drawable.nutri),
            Especialidades("Psicológo(a)", R.drawable.psicologo),
            Especialidades("Dentista", R.drawable.dentista)
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.especialidades?.adapter = especialidadeAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
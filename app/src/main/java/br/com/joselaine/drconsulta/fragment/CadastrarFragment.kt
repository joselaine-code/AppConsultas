package br.com.joselaine.drconsulta.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.joselaine.drconsulta.R
import br.com.joselaine.drconsulta.databinding.FragmentCadastrarBinding
import br.com.joselaine.drconsulta.util.CPFUtil
import br.com.joselaine.drconsulta.util.Mask

class CadastrarFragment : Fragment() {

    private var binding: FragmentCadastrarBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastrarBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.campoCpf?.addTextChangedListener(binding?.campoCpf?.let {
            Mask.mask(
                "###.###.###-##",
                it
            )
        })

        binding?.campoTelefone?.addTextChangedListener(binding?.campoTelefone?.let {
            Mask.mask(
                "(##) #####-####",
                it
            )
        })

        binding?.buttonCadastrar?.setOnClickListener {
            if (CPFUtil.myValidateCPF(binding?.campoCpf?.text.toString()))
                findNavController().navigate(R.id.action_cadastrosFragment_to_checarEmailFragment)
            else
                binding?.layoutCpf?.error = "CPF inválido"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
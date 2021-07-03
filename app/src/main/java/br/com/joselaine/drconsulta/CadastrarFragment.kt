package br.com.joselaine.drconsulta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.joselaine.drconsulta.databinding.FragmentCadastrarBinding
import br.com.joselaine.drconsulta.databinding.FragmentSplashBinding

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
            Mask.mask("###.###.###-##",
                it
            )
        })

        binding?.campoTelefone?.addTextChangedListener(binding?.campoTelefone?.let {
            Mask.mask("(##) #####-####",
                it
            )
        })

        binding?.buttonCadastrar?.setOnClickListener {
            if (CPFUtil.myValidateCPF(binding?.campoCpf?.text.toString()))
                Toast.makeText(context, "CPF válido", Toast.LENGTH_SHORT).show()
            else
                binding?.layoutCpf?.error = "CPF inválido"

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
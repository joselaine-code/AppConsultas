package br.com.joselaine.drconsulta.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.joselaine.drconsulta.R
import br.com.joselaine.drconsulta.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.botaoLogin?.setOnClickListener {
            findNavController().navigate(R.id.action_cadastrosFragment_to_homeFragment)
        }
    }
}
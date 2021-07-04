package br.com.joselaine.drconsulta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.joselaine.drconsulta.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {

    private var binding: FragmentCadastroBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentsList = listOf(CadastrarFragment(), LoginFragment())
        val fragmentsTitleList = listOf("Cadastre-se", "Login")

        activity?.let {
            val viewPagerAdapter = ViewPagerAdapter(
                fragmentManager = childFragmentManager,
                fragmentsList = fragmentsList,
                fragmentsTitleList = fragmentsTitleList
            )
            binding?.let { bindingNonNull ->
                with(bindingNonNull) {
                    vpPages.adapter = viewPagerAdapter
                    tabLayout.setupWithViewPager(vpPages)

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
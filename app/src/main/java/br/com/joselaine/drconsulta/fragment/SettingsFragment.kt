package br.com.joselaine.drconsulta.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import br.com.joselaine.drconsulta.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var binding: FragmentSettingsBinding? = null
    private val sharedPreferences: SharedPreferences by lazy {
        requireActivity().getSharedPreferences("personal_data", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        recuperarPreferencias()
    }

    override fun onStop() {
        super.onStop()
        salvarPreferencias()
    }

    private fun salvarPreferencias() {
        val notificacao = binding?.switchNotificacao?.isChecked
        val dark = binding?.switchTemaEscuro?.isChecked
        val biometria = binding?.switchBiometria?.isChecked

        sharedPreferences.edit {
            notificacao?.let { putBoolean(KEY_SHARED_NOTIFICACAO, it) }
        }

        sharedPreferences.edit {
            dark?.let { putBoolean(KEY_SHARED_DARK, it) }
        }

        sharedPreferences.edit {
            biometria?.let { putBoolean(KEY_SHARED_BIOMETRIA, it) }
        }

    }


    private fun recuperarPreferencias() {
        binding?.switchNotificacao?.isChecked =
            sharedPreferences.getBoolean(KEY_SHARED_NOTIFICACAO, false)
        binding?.switchTemaEscuro?.isChecked =
            sharedPreferences.getBoolean(KEY_SHARED_DARK, false)
        binding?.switchBiometria?.isChecked =
            sharedPreferences.getBoolean(KEY_SHARED_BIOMETRIA, false)
    }

    companion object {
        const val KEY_SHARED_BIOMETRIA = "biometria"
        const val KEY_SHARED_NOTIFICACAO = "notificacao"
        const val KEY_SHARED_DARK = "dark"
    }

}
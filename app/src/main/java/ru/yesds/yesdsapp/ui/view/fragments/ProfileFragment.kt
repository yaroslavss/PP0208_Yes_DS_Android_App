package ru.yesds.yesdsapp.ui.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.databinding.FragmentProfileBinding
import ru.yesds.yesdsapp.ui.viewmodel.UserViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(UserViewModel::class.java)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        val sharedPreferences =
            requireActivity().applicationContext.getSharedPreferences(
                "settings",
                Context.MODE_PRIVATE
            )

        val token = sharedPreferences.getString("API_TOKEN", "")

        println("!!! profile: $token")

        token?.let {
            if (it.isEmpty()) {
                navController.navigate(R.id.loginFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
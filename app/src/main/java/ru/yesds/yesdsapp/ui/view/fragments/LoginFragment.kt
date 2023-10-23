package ru.yesds.yesdsapp.ui.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.databinding.FragmentLoginBinding
import ru.yesds.yesdsapp.model.User
import ru.yesds.yesdsapp.ui.viewmodel.UserViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
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

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        // send auth request
        binding.btnAuth.setOnClickListener {
            val login = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    activity,
                    R.string.msg_empty_auth,
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // dummy login:
            // login = atuny0
            // password = 9uQFF1Lh
            viewModel.signIn(User(login, password, ""))

            viewModel.user.observe(viewLifecycleOwner) { user ->
                println("!!! Login fragment user: $user")

                if (user != null) {
                    val sharedPreferences =
                        requireActivity().applicationContext.getSharedPreferences(
                            "settings",
                            Context.MODE_PRIVATE
                        )
                    sharedPreferences.edit().putString("API_TOKEN", user.token).apply()

                    navController.popBackStack()
                    navController.navigate(R.id.profileFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
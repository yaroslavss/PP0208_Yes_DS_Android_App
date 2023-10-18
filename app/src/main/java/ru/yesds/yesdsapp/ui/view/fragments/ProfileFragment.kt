package ru.yesds.yesdsapp.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.databinding.FragmentProfileBinding
import ru.yesds.yesdsapp.model.User
import ru.yesds.yesdsapp.ui.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(ProfileViewModel::class.java)
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

            viewModel.signIn(User(login, password, ""))
        }

        viewModel.user.observe(viewLifecycleOwner) { user ->
            println("!!! $user")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
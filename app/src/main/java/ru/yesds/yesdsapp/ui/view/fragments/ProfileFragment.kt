package ru.yesds.yesdsapp.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
    private lateinit var scope: CoroutineScope

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

        scope = CoroutineScope(Dispatchers.IO).also { scope ->
            scope.launch {
                viewModel.getUserFromDB().collect { userEntity ->
                    withContext(Dispatchers.Main) {
                        println("!!! PF: userEntity = $userEntity")
                        if (userEntity == null) {
                            navController.navigate(R.id.loginFragment)
                        }
                    }
                }
            }
        }

        // proceed user's sign out
        binding.btnLogout.setOnClickListener {
            viewModel.signOut()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
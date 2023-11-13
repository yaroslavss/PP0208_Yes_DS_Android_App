package ru.yesds.yesdsapp.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.databinding.FragmentMainPageBinding
import ru.yesds.yesdsapp.ui.viewmodel.MainPageViewModel

class MainPageFragment : Fragment() {

    private var _binding: FragmentMainPageBinding? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainPageViewModel::class.java)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainPageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()

        // navigation buttons
        binding.btnAbout.setOnClickListener {
            navController.navigate(R.id.aboutFragment)
        }
        binding.btnStyles.setOnClickListener {
            navController.navigate(R.id.stylesFragment)
        }
        binding.btnPrices.setOnClickListener {
            navController.navigate(R.id.pricesFragment)
        }
        binding.btnTeachers.setOnClickListener {
            navController.navigate(R.id.teachersFragment)
        }
        binding.btnContacts.setOnClickListener {
            navController.navigate(R.id.contactsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
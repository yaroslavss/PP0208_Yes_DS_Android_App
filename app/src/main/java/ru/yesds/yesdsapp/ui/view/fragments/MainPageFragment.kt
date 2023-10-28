package ru.yesds.yesdsapp.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
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

        viewModel.image.observe(viewLifecycleOwner) {
            println("!!! Image: $it")
            Glide.with(this@MainPageFragment)
                .load(it)
                .into(binding.ivCat)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
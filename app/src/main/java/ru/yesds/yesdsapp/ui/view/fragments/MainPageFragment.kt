package ru.yesds.yesdsapp.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.yesds.yesdsapp.databinding.FragmentMainPageBinding
import ru.yesds.yesdsapp.ui.viewmodel.MainPageFragmentViewModel

class MainPageFragment : Fragment() {

    private var _binding: FragmentMainPageBinding? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainPageFragmentViewModel::class.java)
    }
    private val scope = CoroutineScope(Dispatchers.IO)

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

        // make network request
        scope.launch {
            val image = viewModel.getCat().image
            println("Image: $image")
            withContext(Dispatchers.Main) {
                Glide.with(this@MainPageFragment)
                    .load(image)
                    .into(binding.ivCat)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package ru.yesds.yesdsapp.ui.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.yesds.yesdsapp.R
import ru.yesds.yesdsapp.databinding.FragmentStylesBinding
import ru.yesds.yesdsapp.ui.view.adapters.StyleListRecyclerAdapter
import ru.yesds.yesdsapp.ui.viewmodel.StylesViewModel

class StylesFragment : Fragment() {

    private var _binding: FragmentStylesBinding? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(StylesViewModel::class.java)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStylesBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = view.findNavController()
        val adapter = StyleListRecyclerAdapter(listOf()) { style ->
            val bundle = Bundle();
            bundle.putParcelable("style", style);
            navController.navigate(R.id.styleDetailsFragment, bundle)
        }

        binding.rvStyles.adapter = adapter
        binding.rvStyles.layoutManager = LinearLayoutManager(activity)

        viewModel.styleListLiveData.observe(viewLifecycleOwner) { list ->
            adapter.styles = list
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
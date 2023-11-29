package ru.yesds.yesdsapp.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.yesds.yesdsapp.databinding.FragmentStyleDetailsBinding
import ru.yesds.yesdsapp.model.Style

class StyleDetailsFragment : Fragment() {

    private var _binding: FragmentStyleDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStyleDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val style = arguments?.getParcelable("style") as Style?

        style?.let {
            (activity as? AppCompatActivity)?.supportActionBar?.title = style.name
            binding.ivImgStyle.setImageResource(style.image)
            binding.tvStyleText.text = style.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
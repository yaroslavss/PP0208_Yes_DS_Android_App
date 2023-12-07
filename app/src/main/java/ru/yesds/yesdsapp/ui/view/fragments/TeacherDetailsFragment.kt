package ru.yesds.yesdsapp.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.yesds.yesdsapp.databinding.FragmentTeacherDetailsBinding
import ru.yesds.yesdsapp.domain.model.Teacher

class TeacherDetailsFragment : Fragment() {

    private var _binding: FragmentTeacherDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTeacherDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val teacher = arguments?.getParcelable("teacher") as Teacher?

        teacher?.let {
            binding.ivImgBigTeacher.setImageResource(it.photo_big)
            binding.tvTeacherName.text = it.name
            binding.tvTeacherProfession.text = it.profession
            binding.tvTeacherDancesSince.text = it.dances_since
            binding.tvTeacherTeachesSince.text = it.teaches_since
            binding.tvTeacherDescription.text = it.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
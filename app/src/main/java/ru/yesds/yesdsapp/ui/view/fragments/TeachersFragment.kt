package ru.yesds.yesdsapp.ui.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.yesds.yesdsapp.databinding.FragmentTeachersBinding
import ru.yesds.yesdsapp.ui.view.adapters.TeacherListRecyclerAdapter
import ru.yesds.yesdsapp.ui.viewmodel.TeachersViewModel

class TeachersFragment : Fragment() {

    private var _binding: FragmentTeachersBinding? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(TeachersViewModel::class.java)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTeachersBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TeacherListRecyclerAdapter(listOf())

        binding.rvTeachers.adapter = adapter
        binding.rvTeachers.layoutManager = LinearLayoutManager(activity)

        viewModel.teacherListLiveData.observe(viewLifecycleOwner) { list ->
            adapter.teachers = list
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package ru.yesds.yesdsapp.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.yesds.yesdsapp.databinding.ItemTeacherBinding
import ru.yesds.yesdsapp.model.Teacher

class TeacherListRecyclerAdapter(var teachers: List<Teacher>) :
    RecyclerView.Adapter<TeacherListRecyclerAdapter.TeacherViewHolder>() {

    private var _binding: ItemTeacherBinding? = null
    private val binding get() = _binding!!

    inner class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        _binding = ItemTeacherBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TeacherViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return teachers.size
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val item = teachers[position]
        holder.itemView.apply {
            binding.ivImgMinTeacher.setImageResource(item.photo_min)
            binding.tvTeacherName.text = item.name
            if (!item.isLeader)
                binding.tvTeacherLeadership.visibility = View.GONE
            else
                binding.tvTeacherLeadership.text = "Руководитель студии"
            binding.tvTeacherProfession.text = item.profession
        }
    }
}
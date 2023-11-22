package ru.yesds.yesdsapp.ui.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.yesds.yesdsapp.databinding.ItemStyleBinding
import ru.yesds.yesdsapp.model.Style

class StyleListRecyclerAdapter(
    var styles: List<Style>,
) : RecyclerView.Adapter<StyleListRecyclerAdapter.StyleViewHolder>() {

    private var _binding: ItemStyleBinding? = null
    private val binding get() = _binding!!

    inner class StyleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StyleListRecyclerAdapter.StyleViewHolder {
        _binding = ItemStyleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return StyleViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: StyleListRecyclerAdapter.StyleViewHolder, position: Int) {
        val item = styles[position]
        holder.itemView.apply {
            binding.ivImgStyle.setImageResource(item.image)
            binding.tvTitleStyle.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return styles.size
    }
}
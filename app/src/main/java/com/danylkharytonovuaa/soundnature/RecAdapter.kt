package com.danylkharytonovuaa.soundnature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecAdapter(private val dataSet: List<Nature>) :
    RecyclerView.Adapter<RecAdapter.ViewHolder>() {

    lateinit var Listener : OnItemClickListener

    interface OnItemClickListener{
        fun onClickItem(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener)
    {
        Listener = listener
    }

    class ViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val image: ImageView
        init {
            // Define click listener for the ViewHolder's View
            name = view.findViewById(R.id.nameTextViwe)
            image = view.findViewById(R.id.imageNature)
            view.setOnClickListener {
                listener.onClickItem(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)

        return ViewHolder(view, Listener)
    }

    override fun onBindViewHolder(holder: RecAdapter.ViewHolder, position: Int) {
        holder.name.text = dataSet[position].name
        holder.image.setImageResource(dataSet[position].image)
    }

    override fun getItemCount() = 5
}
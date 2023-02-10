package com.example.swipefreshlayout.UpdateRecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.swipefreshlayout.R

// Extends the Adapter class to RecyclerView.Adapter
// and implement the unimplemented methods
class Adapter     // Constructor for initialization
    (var context: Context, var images: ArrayList<*>, var text: ArrayList<*>) :
    RecyclerView.Adapter<RecyclerView.Adapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.Adapter.ViewHolder {
        // Inflating the Layout(Instantiates list_item.xml layout file into View object)
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.course_rv_item, parent, false)

        // Passing view to ViewHolder
        return RecyclerView.Adapter.ViewHolder(view)
    }

    // Binding data to the into specified position
    override fun onBindViewHolder(holder: RecyclerView.Adapter.ViewHolder, position: Int) {
        // TypeCast Object to int type
        val res = images[position] as Int
        holder.images.setImageResource(res)
        holder.text.setText(text[position] as CharSequence)
    }

    override fun getItemCount(): Int {
        // Returns number of items currently available in Adapter
        return text.size
    }

    // Initializing the Views
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var images: ImageView
        var text: TextView

        init {
            images = view.findViewById<View>(R.id.imageView) as ImageView
            text = view.findViewById<View>(R.id.textView) as TextView
        }
    }
}
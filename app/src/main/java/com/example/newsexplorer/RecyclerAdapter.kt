package com.example.newsexplorer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//  RecyclerView Adapter is handled separately in new Kotlin Class
//  RecyclerView Adapter class inherits RecyclerView.Adapter<VH> class
//  where VH is class that extends ViewHolder class
//  RecyclerView Adapter class takes args- i)Data through array,arrayList,separate class etc
//                                        ii) RecyclerView's item listener
//  Args are optional
class RecyclerAdapter(private val listener: ItemClicked,private val a: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerAdapter.Block>() {
//    VIewHolder class defined within RecyclerView Adapter class
    class Block(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Block {
        // Create a new view, which defines the UI of the list item
//        LayoutInflater class changes xml layout to views
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.block, viewGroup, false)
        val block=Block(view)
//        Setting onClickListener to view/block when it is created
        view.setOnClickListener{
            listener.onItemClicked(a[block.adapterPosition])
        }
        return block
    }

    // Replace the contents of a view (invoked by the layout manager)
//    Actual binding of layout content with view content for use
    override fun onBindViewHolder(viewHolder: Block, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = a[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = a.size

}
//    Handling of this onTemClicked function will be done in MainActivity class
//    by overring this function. Takes parameter item - which item(element) was clicked
interface ItemClicked {
    fun onItemClicked(s:String) {
    }

}

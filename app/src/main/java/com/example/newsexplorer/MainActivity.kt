package com.example.newsexplorer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsexplorer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemClicked {
    private lateinit var binding: ActivityMainBinding
    private var arr = arrayListOf<String>()
//    Member variables of the class has general syntax like- mVariableName
//    where m stands for member
    private lateinit var mAdapter:RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        this.arr =makeArr(arr)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        mAdapter = RecyclerAdapter(this,arr)
        binding.recyclerview.adapter = mAdapter
    }
//    Storing elements in the array
    private fun makeArr(arr:ArrayList<String>): ArrayList<String> {
        for(i in 1..100){
            arr.add("Item $i")
        }
        return arr
    }
//    Handling RecyclerView's item clicking in Main Activity
    override fun onItemClicked(s: String) {
        Toast.makeText(this,"$s was clicked",Toast.LENGTH_SHORT).show()
    }
}
package com.example.wishlistapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.Wishlist

class MainActivity : AppCompatActivity(){
    lateinit var data: ArrayList<Wishlist>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var index = 0
        val button = findViewById<Button>(R.id.button)
        val nameInput = findViewById<EditText>(R.id.name)
        val priceInput = findViewById<EditText>(R.id.price)
        val linkInput = findViewById<EditText>(R.id.link)
        val wishRv = findViewById<RecyclerView>(R.id.wishRv)
        data = ArrayList()
        var adapter = WishlistAdapter(data)
        wishRv.adapter = adapter
        wishRv.layoutManager = LinearLayoutManager(this)
        button.setOnClickListener {
            data.add(Wishlist(nameInput.text.toString(), priceInput.text.toString(), linkInput.text.toString()))
            adapter.notifyItemInserted(index)

//            Log.d("Wishlist:", )
            index++

        }
    }
}
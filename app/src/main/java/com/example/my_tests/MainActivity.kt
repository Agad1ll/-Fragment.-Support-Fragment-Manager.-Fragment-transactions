package com.example.my_tests

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.BinderThread
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_tests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listOfProduct = mutableListOf<Product>(
            Product("apple", 100),
            Product("orange", 190),
            Product("banana", 160),
            Product("strawberry", 250),
            Product("blueberry", 400),
            Product("raspberry", 350),
            Product("tomato", 120),
            Product("cucumber", 90),
            Product("potato", 50),
            Product("milk", 80),
            Product("cheese", 450),
            Product("yogurt", 65),
            Product("bread", 45),
            Product("croissant", 110),
            Product("baguette", 75),
            Product("chicken", 280),
            Product("beef", 550),
            Product("pork", 420),
            Product("salmon", 890),
            Product("shrimp", 750),
        )
        val adapter= ExampleRecyclerAdapter()
        binding.rcProducts.adapter=adapter
        adapter.submitList(listOfProduct)
        val fragment1= ExampleFirstFragment()
        binding.btnShowFragmentFirst.setOnClickListener {
            supportFragmentManager.beginTransaction().add(binding.tvPlaceForFragment.id,fragment1).commit()
        val fragment2= ExampleSecondFragment()
        binding.button5.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(binding.tvPlaceForFragment.id,fragment2).commit()
        }

        binding.btnRemoveFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().remove(fragment1).commit()
            supportFragmentManager.beginTransaction().remove(fragment2).commit()
        }


        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }
}
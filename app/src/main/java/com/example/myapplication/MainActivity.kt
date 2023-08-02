package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.myapplication.adapter.DetailsRecyclerAdapter
import com.example.myapplication.adapter.ProductRecyclerAdapter
import com.example.myapplication.adapter.VariantRecyclerAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
//        lifecycleScope.launch(Dispatchers.IO) { getResponse() }

        binding.variantRecyclerView.adapter = VariantRecyclerAdapter(this)

        val detailsList = listOf(
            "Raw",
            "Comes in pouch"
        )
        binding.detailsRecyclerView.adapter = DetailsRecyclerAdapter(detailsList)

        binding.similarProdRecyclerView.adapter = ProductRecyclerAdapter()

        binding.mostViewedProdRecyclerView.adapter = ProductRecyclerAdapter()
    }

    private suspend fun getResponse() {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            repository.getData().collect {
                withContext(Dispatchers.Main) {
//                    val adapter = MyRecyclerAdapter(it.entries)
//                    binding.recyclerView.adapter = adapter
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}
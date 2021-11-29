package com.agening.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.agening.viewmodel.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        vm.resultLive.observe(this, Observer {
            binding.dataTextView.text = it
        })

        binding.sendButton.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            vm.save(text)
        }

        binding.receiveDate.setOnClickListener {

            vm.load()
        }

    }
}
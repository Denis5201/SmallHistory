package com.example.smallhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smallhistory.databinding.ActivityMainBinding

class EndActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = getString(R.string.end)
        binding.button.text = getString(R.string.returnB)

        binding.button.setOnClickListener {
            val int = Intent(this, MainActivity::class.java)
            int.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(int)
        }
    }
}
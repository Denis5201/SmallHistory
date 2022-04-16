package com.example.smallhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smallhistory.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonName.setOnClickListener {
            val userName = binding.enterName.text.toString()
            if (userName.isNotEmpty()) {
                val intent = Intent(this, WorkActivity::class.java)
                intent.putExtra(Constants.NAME, userName)
                intent.putExtra(Constants.CHOICE, 0)
                startActivity(intent)
            }
        }
    }
}
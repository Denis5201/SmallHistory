package com.example.smallhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smallhistory.databinding.ActivityStandartBinding

class SuitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStandartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setImageResource(R.drawable.suit)
        binding.message.text = getText(R.string.suitText)
        binding.secondButton.text = getText(R.string.suitB2)
        binding.thirdButton.text = getText(R.string.suitB3)

        val int = Intent(this, EvaluationActivity::class.java)
        binding.secondButton.setOnClickListener {
            int.putExtra("choice", 3)
            startActivity(int)
        }
        binding.thirdButton.setOnClickListener {
            int.putExtra("choice", 4)
            startActivity(int)
        }
    }
}
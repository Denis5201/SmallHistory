package com.example.smallhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.smallhistory.databinding.ActivityStandartBinding

class EvaluationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStandartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val choose = intent.getIntExtra("choice",0)
        val resource = when(choose) {
            1,2 -> R.drawable.film
            3,4 -> R.drawable.suit
            else -> 0
        }
        binding.imageView.setImageResource(resource)

        binding.thirdButton.visibility = View.INVISIBLE
        binding.message.text = getString(when(choose) {
            1 -> R.string.filmGood
            2 -> R.string.filmBad
            3 -> R.string.suitGood
            4 -> R.string.suitBad
            else -> R.string.error
        })
        binding.secondButton.text = getString(R.string.late)
        binding.secondButton.setOnClickListener {
            val int = Intent(this, EndActivity::class.java)
            startActivity(int)
        }
    }
}
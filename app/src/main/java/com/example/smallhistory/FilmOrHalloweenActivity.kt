package com.example.smallhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smallhistory.databinding.ActivityStandartBinding

class FilmOrHalloweenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStandartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val choose = intent.getIntExtra("choice",0)
        val resource = when(choose) {
            1 -> R.drawable.film
            2 -> R.drawable.helloween
            else -> 0
        }
        binding.imageView.setImageResource(resource)

        binding.message.text = getString(when(choose) {
            1 -> R.string.filmText
            2 -> R.string.halloweenText
            else -> R.string.error
        })
        binding.secondButton.text = getString(when(choose){
            1 -> R.string.filmB2
            2 -> R.string.halloweenB2
            else -> R.string.error
        })
        binding.thirdButton.text = getString(when(choose){
            1 -> R.string.filmB3
            2 -> R.string.halloweenB3
            else -> R.string.error
        })

        if (choose == 1) {
            val int = Intent(this, EvaluationActivity::class.java)
            binding.secondButton.setOnClickListener {
                int.putExtra("choice", 1)
                startActivity(int)
            }
            binding.thirdButton.setOnClickListener {
                int.putExtra("choice", 2)
                startActivity(int)
            }
        }
        else {
            binding.secondButton.setOnClickListener {
                val int = Intent(this, FilmOrHalloweenActivity::class.java)
                int.putExtra("choice", 1)
                startActivity(int)
            }
            binding.thirdButton.setOnClickListener {
                val int = Intent(this, SuitActivity::class.java)
                startActivity(int)
            }
        }
    }
}
package com.example.smallhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.smallhistory.databinding.ActivityStandartBinding

class MainActionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStandartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val choose = intent.getIntExtra("choice",0)

        val resource = when(choose) {
            1 -> R.drawable.run
            2 -> R.drawable.camping
            3 -> R.drawable.field
            else -> 0
        }
        binding.imageView.setImageResource(resource)

        binding.message.text = getString(when(choose) {
            1 -> R.string.runText
            2 -> R.string.campingText
            3 -> R.string.fieldText
            else -> R.string.error
        })
        binding.secondButton.text = getString(when(choose){
            1 -> R.string.runB2
            2 -> R.string.campingB2
            3 -> R.string.fieldB2
            else -> R.string.error
        })
        binding.thirdButton.text = getString(when(choose){
            1 -> R.string.runB3
            2 -> R.string.campingB3
            3 -> R.string.fieldB3
            else -> R.string.error
        })

        val int = Intent(this, FilmOrHalloweenActivity::class.java)
        binding.secondButton.setOnClickListener {
            int.putExtra("choice", 1)
            startActivity(int)
        }
        binding.thirdButton.setOnClickListener {
            int.putExtra("choice", 2)
            startActivity(int)
        }
    }
}
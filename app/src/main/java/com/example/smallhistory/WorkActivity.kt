package com.example.smallhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.smallhistory.databinding.ActivityStandartBinding

class WorkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStandartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val choose = intent.getIntExtra(Constants.CHOICE,0)

        val resource = when(choose) {
            1 -> R.drawable.run
            2 -> R.drawable.camping
            3 -> R.drawable.field
            4, 5, 6 -> R.drawable.film
            7 -> R.drawable.helloween
            8, 9, 10 -> R.drawable.suit
            else -> R.drawable.main
        }
        binding.imageView.setImageResource(resource)

        when (choose) {
            0 -> binding.firstButton.visibility = View.VISIBLE
            5, 6, 9, 10 -> binding.thirdButton.visibility = View.INVISIBLE
        }

        binding.message.text = getString(when(choose) {
            1 -> R.string.runText
            2 -> R.string.campingText
            3 -> R.string.fieldText
            4 -> R.string.filmText
            5 -> R.string.filmGood
            6 -> R.string.filmBad
            7 -> R.string.halloweenText
            8 -> R.string.suitText
            9 -> R.string.suitGood
            10 -> R.string.suitBad
            else -> R.string.error
        })
        binding.secondButton.text = getString(when(choose) {
            0 -> R.string.campingChoice
            1 -> R.string.runB2
            2 -> R.string.campingB2
            3 -> R.string.fieldB2
            4 -> R.string.filmB2
            5, 6, 9, 10 -> R.string.late
            7 -> R.string.halloweenB2
            8 -> R.string.suitB2
            else -> R.string.error
        })
        binding.thirdButton.text = getString(when(choose) {
            0 -> R.string.fieldChoice
            1 -> R.string.runB3
            2 -> R.string.campingB3
            3 -> R.string.fieldB3
            4 -> R.string.filmB3
            7 -> R.string.halloweenB3
            8 -> R.string.suitB3
            else -> R.string.error
        })

        val int = when(choose) {
            5,6,9,10->Intent(this, EndActivity::class.java)
            else->Intent(this, WorkActivity::class.java)
        }

        binding.secondButton.setOnClickListener {
            val next = when (choose) {
                0 -> 2
                1, 2, 3 -> 4
                4 -> 5
                7 -> 4
                8 -> 9
                else -> 0
            }
            int.putExtra(Constants.CHOICE, next)
            startActivity(int)
        }
        binding.thirdButton.setOnClickListener {
            val next = when (choose) {
                0 -> 3
                1, 2, 3 -> 7
                4 -> 6
                7 -> 8
                8 -> 10
                else -> 0
            }
            int.putExtra(Constants.CHOICE, next)
            startActivity(int)
        }

        if (choose == 0) {
            binding.kirysha.visibility = View.VISIBLE

            val name = intent.getStringExtra(Constants.NAME)
            val mes = "Отлично, $name! Чем займёмся?"
            binding.message.text = mes

            binding.firstButton.text = getString(R.string.runChoice)
            binding.firstButton.setOnClickListener {
                int.putExtra(Constants.CHOICE, 1)
                startActivity(int)
            }
        }
    }
}
package com.example.smallhistory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.smallhistory.databinding.ActivityStandartBinding

class MainChoiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStandartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kirysha.visibility = View.VISIBLE

        val name = intent.getStringExtra("userName")
        val mes = "Отлично, $name! Чем займёмся?"
        binding.message.text = mes

        binding.firstButton.visibility = View.VISIBLE

        val int = Intent(this, MainActionActivity::class.java)

        binding.firstButton.text = getString(R.string.runChoice)
        binding.firstButton.setOnClickListener {
            int.putExtra("choice", 1)
            startActivity(int)
        }
        binding.secondButton.text = getString(R.string.campingChoice)
        binding.secondButton.setOnClickListener {
            int.putExtra("choice", 2)
            startActivity(int)
        }
        binding.thirdButton.text = getString(R.string.fieldChoice)
        binding.thirdButton.setOnClickListener {
            int.putExtra("choice", 3)
            startActivity(int)
        }
    }
}
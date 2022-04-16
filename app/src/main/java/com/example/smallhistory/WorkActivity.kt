package com.example.smallhistory

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smallhistory.databinding.ActivityStandartBinding
import com.google.gson.Gson


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

        val jsonStr = assets.open("scenes.json").bufferedReader().use { it.readText() }
        val jsonData = Gson().fromJson(jsonStr, Scenes::class.java)

        binding.message.text = jsonData.scenes[choose].text

        var myIntent = Intent(this, WorkActivity::class.java)

        if (jsonData.scenes[choose].buttons.size==1){
            binding.thirdButton.visibility = View.INVISIBLE
            binding.secondButton.text = jsonData.scenes[choose].buttons[0].text

            myIntent = Intent(this, EndActivity::class.java)
            binding.secondButton.setOnClickListener {
                myIntent.putExtra(Constants.CHOICE, jsonData.scenes[choose].buttons[0].next)
                startActivity(myIntent)
            }
        }
        else if (jsonData.scenes[choose].buttons.size==2){
            binding.secondButton.text = jsonData.scenes[choose].buttons[0].text
            binding.thirdButton.text = jsonData.scenes[choose].buttons[1].text

            binding.secondButton.setOnClickListener {
                myIntent.putExtra(Constants.CHOICE, jsonData.scenes[choose].buttons[0].next)
                startActivity(myIntent)
            }
            binding.thirdButton.setOnClickListener {
                myIntent.putExtra(Constants.CHOICE, jsonData.scenes[choose].buttons[1].next)
                startActivity(myIntent)
            }
        }
        else if (jsonData.scenes[choose].buttons.size==3){
            binding.kirysha.visibility = View.VISIBLE

            val name = intent.getStringExtra(Constants.NAME)
            val mes = "Отлично, $name! Чем займёмся?"
            binding.message.text = mes

            binding.firstButton.visibility = View.VISIBLE
            binding.firstButton.text = jsonData.scenes[choose].buttons[0].text
            binding.secondButton.text = jsonData.scenes[choose].buttons[1].text
            binding.thirdButton.text = jsonData.scenes[choose].buttons[2].text

            binding.firstButton.setOnClickListener {
                myIntent.putExtra(Constants.CHOICE, jsonData.scenes[choose].buttons[0].next)
                startActivity(myIntent)
            }
            binding.secondButton.setOnClickListener {
                myIntent.putExtra(Constants.CHOICE, jsonData.scenes[choose].buttons[1].next)
                startActivity(myIntent)
            }
            binding.thirdButton.setOnClickListener {
                myIntent.putExtra(Constants.CHOICE, jsonData.scenes[choose].buttons[2].next)
                startActivity(myIntent)
            }
        }
    }
}
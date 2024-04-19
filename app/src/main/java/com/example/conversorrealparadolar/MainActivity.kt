package com.example.conversorrealparadolar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversorrealparadolar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btConversor.setOnClickListener {

            val real = binding.editReal.text.toString()
            val resultado = binding.textDolar


            if (real.isEmpty()) {

                Toast.makeText(this, "Coloque algum valor", Toast.LENGTH_SHORT).show()

            } else {

                val dolar = String.format("%.2f", real.toDouble() / 5)

                resultado.setText("$ " + dolar)

            }
        }
    }
}

package com.example.media_escolar



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.media_escolar.databinding.ActivityMainBinding
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val trabalho1 = binding.txtTrabalho1
        val trabalho2  = binding.txtTrabalho2
        val teste = binding.txtTeste
        val prova  = binding.txtProva
        val nomeAluno: EditText = binding.txtAluno
        val resultado: TextView = binding.txtResultado

       binding.btCalulcarMedia.setOnClickListener {
           val nome = nomeAluno.text.toString()
           val nota1: Double = parseDouble(trabalho1.text.toString())
           val nota2: Double = parseDouble(trabalho2.text.toString())
           val nota3: Double = parseDouble(teste.text.toString())
           val nota4: Double = parseDouble(prova.text.toString())
           val decimal = DecimalFormat("##.#")

           val media = (nota1 + nota2 + nota3 + nota4) / 4


           if (media >= 5) {
               resultado.text = "Média final: ${decimal.format(media)} \nAluno(a) $nome está APROVADO!"
               //resultado.setTextColor(getColor(R.color.blue))
           } else {
               resultado.text= "Média final: ${decimal.format(media)} \nAluno(a) $nome está REPROVADO."
               //resultado.setTextColor(getColor(R.color.red))
           }


           binding.btLimpar.setOnClickListener {
               nomeAluno.text.clear()
               trabalho1.text.clear()
               trabalho2.text.clear()
               teste.text.clear()
               prova.text.clear()
               resultado.text = ""
           }
       }

     }
}


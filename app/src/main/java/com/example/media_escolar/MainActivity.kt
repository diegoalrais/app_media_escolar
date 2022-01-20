package com.example.media_escolar



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.media_escolar.databinding.ActivityMainBinding
import java.lang.Integer.parseInt

//import java.text.DecimalFormat

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
           val nota1: Int = parseInt(trabalho1.text.toString())
           val nota2: Int = parseInt(trabalho2.text.toString())
           val nota3: Int = parseInt(teste.text.toString())
           val nota4: Int = parseInt(prova.text.toString())

           val media = (nota1 + nota2 + nota3 + nota4) / 4
           //val dec = DecimalFormat("##.#") ${dec.format(media)} ${dec.format(media)}

           if (media >= 5) {
               resultado.text = "Média final: $media. \nAluno(a) $nome está APROVADO!"
               //resultado.setTextColor(getColor(R.color.blue))
           } else {
               resultado.text= "Média final: $media. \nAluno(a) $nome está REPROVADO."
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




    /*


        val valor1 = Double.parseDouble(nota1.text.toString())
        val valor2 = Double.parseDouble(nota2.text.toString())
        val valor3 = Double.parseDouble(nota3.text.toString())
        val valor4 = Double.parseDouble(nota4.text.toString())


        binding.btCalulcarMedia.setOnClickListener {

            val media = (valor1 + valor2 + valor3 + valor4) /4
            val dec = DecimalFormat("##.#")

            if (media >= 6) {
                resultado.setText("O alunos(a) $nomeAluno foi aprovado com sucesso. \n Sua média final foi: ${dec.format(media)} ")
                resultado.setTextColor(getColor(R.color.blue))
            } else {
                resultado.setText("O alunos(a) $nomeAluno foi reprovado com sucesso. \n Sua média final foi: ${dec.format(media)} ")
                resultado.setTextColor(getColor(R.color.red))
            }
        }*/
    }
}


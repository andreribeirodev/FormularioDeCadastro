package com.example.formulariodecadastroalura.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulariodecadastroalura.databinding.ActivitySucessBinding
import com.example.formulariodecadastroalura.model.Address
import com.example.formulariodecadastroalura.model.User


class SucessActivity : AppCompatActivity() {

    lateinit var binding: ActivitySucessBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySucessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.extras?.getParcelable<User>("user")!!
        val address = intent.extras!!.getParcelable<Address>("address")!!

        binding.textViewName.text = "Nome: ${user.name}"
        binding.textViewCell.text = "Telefone: ${user.cell}"
        binding.textViewCep.text = "Cep: ${address.cep.toString()}"
        binding.textViewLogradouro.text = "Logradouro: ${address.logradouro.toString()}"
        binding.textViewNumber.text = "Número: ${address.numero.toString()}"
        binding.textViewBairro.text = "Bairro: ${address.bairro.toString()}"
        binding.textViewComplements.text = "Complemento: ${address.complemento.toString()}"
        binding.textViewCity.text = "Cidade: ${address.cidade.toString()}"

    }

}
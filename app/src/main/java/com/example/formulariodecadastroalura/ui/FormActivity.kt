package com.example.formulariodecadastroalura.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulariodecadastroalura.databinding.ActivityFormBinding
import com.example.formulariodecadastroalura.model.Address
import com.example.formulariodecadastroalura.model.User
import com.example.formulariodecadastroalura.util.MaskFormatUtil


class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideActionBar()
        setMaskFields()

        val user = intent.extras?.getParcelable<User>("user")!!


        binding.buttonFinishRegister.setOnClickListener{

            val address = Address(
                cep = binding.editTextCep.text.toString(),
                logradouro = binding.editTextLogradouro.text.toString(),
                numero = binding.editTextNumber.text.toString(),
                bairro = binding.editTextBairro.text.toString(),
                complemento = binding.editTextComplemento.text.toString(),
                cidade = binding.editTextCity.text.toString()
            )


            val intent = Intent (this,SucessActivity::class.java)
                .putExtra("user", user)
                .putExtra("address", address)
            startActivity(intent)

        }

    }

    private fun setMaskFields() {
        val editTextCep = binding.editTextCep
        editTextCep.addTextChangedListener(
            MaskFormatUtil.mask(
                editTextCep,
                MaskFormatUtil.FORMAT_CEP
            )
        )
    }

    private fun hideActionBar() {
        if (supportActionBar != null){
            supportActionBar?.hide()
        }
    }
}
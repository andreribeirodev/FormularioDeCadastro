package com.example.formulariodecadastroalura.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import com.example.formulariodecadastroalura.databinding.ActivityHomeBinding
import com.example.formulariodecadastroalura.model.User
import com.example.formulariodecadastroalura.util.MaskFormatUtil


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setMaskFields()

        if (supportActionBar != null) {
            supportActionBar?.hide()
        }


        binding.buttonStartRegister.setOnClickListener {
            val user = User(
                name = binding.editTextName.text.toString(),
                cell = binding.editTextCell.text.toString()
            )

            val intent = Intent(this, FormActivity::class.java)
                .putExtra("user", user)
            startActivity(intent)
            finish()

        }

    }

    private fun setMaskFields() {
        val editTextCell = binding.editTextCell
        editTextCell.addTextChangedListener(
            MaskFormatUtil.mask(
                editTextCell,
                MaskFormatUtil.FORMAT_FONE_COD_AREA
            )
        )
    }
}
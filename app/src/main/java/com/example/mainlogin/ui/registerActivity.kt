package com.example.mainlogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mainlogin.databinding.ActivityRegisterBinding
import entidades.Fintech

class registerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrarse.setOnClickListener {

            val usuario = binding.etNuevoUsuario.text.toString()
            val password = binding.etNuevaPassword.text.toString()
            val nombre = binding.etNuevoNombre.text.toString()
            val apellido = binding.etNuevoApellido.text.toString()

            if (!Fintech.nickValidation(usuario)) {
                Fintech.agregamosUsuarioYPassword(usuario, password)
                Fintech.agregamosNombreYApellido(nombre, apellido)
                Toast.makeText(this, "Usuario creado con éxito.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "no se puedo agregar", Toast.LENGTH_LONG).show()
            }

            val ActivityBack : Intent = Intent(this, MainActivity::class.java)
            startActivity(ActivityBack)


        }
    }
}
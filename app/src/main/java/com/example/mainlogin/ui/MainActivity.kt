package com.example.mainlogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dataClass.Cuentas
import entidades.Fintech
import com.example.mainlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvRegistrarse.setOnClickListener {

            val registro: Intent = Intent(this, registerActivity::class.java)
            startActivity(registro)

        }

        binding.btnIngresar.setOnClickListener {
            val usuario = binding.tvUsuario.text.toString()
            val password = binding.tvPassword.text.toString()
            var codigoDeCuenta: Int = 0
            var cuentaEncontrada: Cuentas? = null

            if (Fintech.nickValidation(usuario) && Fintech.passValidation(password)) {

                codigoDeCuenta = Fintech.buscarCodigoDeCuentaEnRepositorioUsuario(usuario)
                cuentaEncontrada = Fintech.buscarCuentaEnRepositorioCuenta(codigoDeCuenta)

                val perfil: Intent = Intent(this, PerfilActivity::class.java)

                perfil.putExtra("codigo", cuentaEncontrada!!.codigoCuenta)
                perfil.putExtra("usuario", usuario)
                startActivity(perfil)

                Toast.makeText(
                    this,
                    "Bienvenido ${cuentaEncontrada.nombre} a Orange bank.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(this, "No pudiste ingregar, intentalo más tarde.", Toast.LENGTH_LONG)
                    .show()
            }

        }

    }
}

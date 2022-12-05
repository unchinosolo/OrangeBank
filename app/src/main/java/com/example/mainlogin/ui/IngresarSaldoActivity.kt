package com.example.mainlogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mainlogin.databinding.ActivityIngresarsaldosBinding
import entidades.Fintech

class IngresarSaldoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityIngresarsaldosBinding =
            ActivityIngresarsaldosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        var codigoDeCuentas: Int = bundle!!.getInt("codigo")
        val nombreUsuario: String? = bundle!!.getString("usuario")

        binding.BTCargarSaldo.setOnClickListener {
            val bundleIntent: Bundle? = intent.extras
            val codigo: Int = bundleIntent!!.getInt("codigo")

            val saldoIngresado = binding.ABIngresarSaldo.text.toString()

            if (Fintech.agregarSaldoEnElCuenta(codigo, saldoIngresado.toDouble())) {

                val perfil: Intent = Intent(this, PerfilActivity::class.java)
                perfil.putExtra("codigo", codigo)
                perfil.putExtra("usuario", nombreUsuario)
                startActivity(perfil)

                Toast.makeText(
                    this,
                    "Se agregaron ${saldoIngresado} a tu cuenta de Orange bank.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Ops, no se pudo agregar saldo en tu cuenta de Orange bank.",
                    Toast.LENGTH_LONG
                ).show()
            }

        }


    }

}
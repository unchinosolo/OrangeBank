package com.example.mainlogin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mainlogin.databinding.ActivityComprarBitcoinsBinding
import entidades.Fintech

class ComprarBitcoinsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityComprarBitcoinsBinding =
            ActivityComprarBitcoinsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle: Bundle? = intent.extras
        val nombreUsuario: String? = bundle!!.getString("usuario")

        var monedaSelccionada =
            Fintech.listaCriptos.find { cripto -> cripto.nombre.equals("CarreCripto") }!!

        binding.btnCarrecripto.setOnClickListener {

            monedaSelccionada =
                Fintech.listaCriptos.find { cripto -> cripto.nombre.equals("CarreCripto") }!!

            Toast.makeText(this, monedaSelccionada.nombre, Toast.LENGTH_LONG).show()
        }

        binding.btnCriptodia.setOnClickListener {

            monedaSelccionada =
                Fintech.listaCriptos.find { cripto -> cripto.nombre.equals("CriptpDia") }!!

            Toast.makeText(this, monedaSelccionada.nombre, Toast.LENGTH_LONG).show()
        }

        binding.btnCriptomas.setOnClickListener {

            monedaSelccionada =
                Fintech.listaCriptos.find { cripto -> cripto.nombre.equals("CriptoMas") }!!

            Toast.makeText(this, monedaSelccionada.nombre, Toast.LENGTH_LONG).show()
        }


        binding.btnCompraBitcoin.setOnClickListener {
            val bundleCompraBit: Bundle? = intent.extras
            val codigoDeCuentas: Int = bundleCompraBit!!.getInt("codigo")

            val saldoIngresado = binding.etMontoBitcoin.text.toString()
            val cuenta =
                Fintech.listaCuentas.find { cuenta -> cuenta.codigoCuenta == codigoDeCuentas }!!;

            if (Fintech.agregarSaldoEnBitcoins(
                    cuenta,
                    saldoIngresado.toDouble(),
                    monedaSelccionada
                )
            ) {

                val perfil: Intent = Intent(this, PerfilActivity::class.java)
                perfil.putExtra("codigo", codigoDeCuentas)
                perfil.putExtra("usuario", nombreUsuario)
                startActivity(perfil)

                Toast.makeText(
                    this,
                    "Se agregaron bitcoins a tu cuenta de Orange bank.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Ops, no se pudo agregar bitcoins en tu cuenta de Orange bank.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
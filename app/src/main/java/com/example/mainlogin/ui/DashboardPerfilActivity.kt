package com.example.mainlogin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mainlogin.databinding.ActivityDashboardperfilBinding
import entidades.Fintech

class DashboardPerfilActivity: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding : ActivityDashboardperfilBinding = ActivityDashboardperfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        var codigoDeCuentas: Int = bundle!!.getInt("codigo")

        //Mostrar nombre (25/11)
        var datoNombre = Fintech.mostrarNombreDelUsuarioEnElDashboard(codigoDeCuentas)
        binding.tvNombre.text = datoNombre.toString()

        //Mostrar usuario (25/11)
        var datoUsuario = Fintech.mostrarUsuarioDellUsuarioEnElDashboard(codigoDeCuentas)
        binding.tvUsuario.text = datoUsuario.toString()

        //Mostrar apellido (25/11)
        var datoApellido = Fintech.mostrarApellidooDelUsuarioEnElDashboard(codigoDeCuentas)
        binding.tvApellido.text = datoApellido.toString()

        //Mostrar fecha de alta (25/11)
        //var datoFecha = Fintech.mostrarDineroDellUsuarioEnElDashboard(codigoDeCuentas)
        //binding.tvFecha.text = datoFecha.toString()

    }
}
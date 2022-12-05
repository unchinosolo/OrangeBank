package com.example.mainlogin.ui

import adapter.AdaptadorTickets
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainlogin.R
import clases.Tickets
import repositorios.MovimientosRepositorio
import java.time.LocalDate
import java.time.LocalTime

class MovimientosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movimientos)

        val rvTickets = findViewById<RecyclerView>(R.id.rvEquipos)
        rvTickets.layoutManager = LinearLayoutManager(this)

        val listaTickets = MovimientosRepositorio.obtenerMovimientos()

        val adaptadorTickets = AdaptadorTickets(listaTickets)
        rvTickets.adapter = adaptadorTickets
    }
}
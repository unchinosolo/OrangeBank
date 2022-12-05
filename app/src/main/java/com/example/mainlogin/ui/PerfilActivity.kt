package com.example.mainlogin.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainlogin.databinding.ActivityPerfilBinding
import entidades.Fintech


class PerfilActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityPerfilBinding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        var codigoDeCuentas: Int = bundle!!.getInt("codigo")

        var saldoEnPerfil = Fintech.mostrarSaldoEnElPerfilActivy(codigoDeCuentas)
        binding.tvSaldo.text = "$ ${saldoEnPerfil.toString()}"

        var saldoEnBTPerfil = Fintech.mostrarSaldoEnBitCoinEnElPerfilActivy(codigoDeCuentas)
        binding.tvSaldo2.text = "$ ${saldoEnBTPerfil.toString()}"

        var nombreUsuario: String? = bundle!!.getString("usuario")
        binding.tvBienvenida1.text = "Bienvenid@ $nombreUsuario"


        // Llamamos al activity Comprar bitcoins
        binding.btnComprar.setOnClickListener {
            val bundleComprar: Bundle? = intent.extras
            var codigoDeCuentasComprar: Int = bundleComprar!!.getInt("codigo")

            val comprarBitcoinsActivity: Intent = Intent(this, ComprarBitcoinsActivity::class.java)
            comprarBitcoinsActivity.putExtra("codigo", codigoDeCuentasComprar)
            comprarBitcoinsActivity.putExtra("usuario", nombreUsuario)

            startActivity(comprarBitcoinsActivity)
        }
        // Llamamos al activity Movimientos
        binding.btnCuenta.setOnClickListener {

            val movimientos: Intent = Intent(this, MovimientosActivity::class.java)
            startActivity(movimientos)

        }
        // Llamamos al activity Ingresar saldo
        binding.btnDepositar.setOnClickListener {

            val bundleDepositar: Bundle? = intent.extras
            var codigoDeCuentasDepositar: Int = bundleDepositar!!.getInt("codigo")

            val depositar: Intent = Intent(this, IngresarSaldoActivity::class.java)
            depositar.putExtra("codigo", codigoDeCuentasDepositar)
            depositar.putExtra("usuario", nombreUsuario)
            startActivity(depositar)

        }

        //Boton Mostrar perfil (25/11)
        binding.btnHome.setOnClickListener {
            val bundleHome: Bundle? = intent.extras
            var codigoDeCuentasPerfil: Int = bundleHome!!.getInt("codigo")
            val mostrarDashboard: Intent = Intent(this, DashboardPerfilActivity::class.java)
            mostrarDashboard.putExtra("codigo", codigoDeCuentasPerfil)
            startActivity(mostrarDashboard)
        }
    }
}

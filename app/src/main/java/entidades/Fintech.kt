package entidades

import Interfaces.AutenticacionUsuario
import clases.Tickets
import dataClass.Compra
import dataClass.Cripto
import dataClass.Cuentas
import dataClass.Usuario
import repositorios.CompraRepositorio
import repositorios.CuentaRepo
import repositorios.MovimientosRepositorio
import repositorios.UsuarioRepo
import java.time.LocalDate
import java.time.LocalTime

object Fintech : AutenticacionUsuario {

    val listaUsuario = UsuarioRepo.usuarios
    val listaCuentas = CuentaRepo.cuentas
    val listaCompras = CompraRepositorio.compra
    val listaCriptos = CompraRepositorio.criptos

    // INICIO DE SESION - METODOS
    // Buscamos en la listaDeUsario que tenga el mismo codigo para vincular Usuario y Cuenta

    fun buscarCodigoDeCuentaEnRepositorioUsuario(usuario: String): Int {

        var codigoDeCuenta = 0
        for (usario in listaUsuario) {
            if (usario.usuario.equals(usuario)) {
                codigoDeCuenta = usario.codigo
                break
            }
        }
        return codigoDeCuenta
    }

    //Buscamos un codigo de cuenta en la listaDeCuenta

    fun buscarCuentaEnRepositorioCuenta(codigoDeCuentas: Int): Cuentas? {

        var cuentaEncontrada: Cuentas? = null

        for (cuenta in listaCuentas) {
            if (cuenta.codigoCuenta == codigoDeCuentas) {
                cuentaEncontrada = cuenta
                break
            }
        }
        return cuentaEncontrada!!
    }

    // Metodo de agregar cuenta a repo usuario
    fun agregamosUsuarioYPassword(usuario: String, password: String) {
        listaUsuario.add(Usuario(usuario, password, listaUsuario.size.plus(1)))
    }

    // Metodo agregar nombre y apellido a repo cuenta
    fun agregamosNombreYApellido(nombre: String, apellido: String) {
        listaCuentas.add(
            Cuentas(
                listaCuentas.size.plus(1),
                nombre,
                apellido,
                0.0,
                LocalDate.now().toString(),
                0.0
            )
        )

    }
    //  IMPLEMENTACION A INTERFACES

    override fun nickValidation(nickname: String): Boolean {
        return super.nickValidation(nickname)
    }

    override fun passValidation(password: String): Boolean {
        return super.passValidation(password)
    }


    //Funcion mostrar Saldo en el PerfilActivy

    fun mostrarSaldoEnElPerfilActivy(codigoDeCuentas: Int): Double? {

        var cuentaEncontrada: Double? = null

        for (cuenta in listaCuentas) {
            if (cuenta.codigoCuenta == codigoDeCuentas) {
                cuentaEncontrada = cuenta.dineroEnCuenta
                break
            }
        }
        return cuentaEncontrada
    }

    //Funcion agregar Saldo en la cuenta

    fun agregarSaldoEnElCuenta(codigoDeCuentas: Int, dineroIngresado: Double): Boolean {

        for (cuenta in listaCuentas) {
            if (cuenta.codigoCuenta == codigoDeCuentas && dineroIngresado > 0.0) {
                cuenta.dineroEnCuenta = cuenta.dineroEnCuenta.plus(dineroIngresado);
                return true;
            }
        }
        return false;
    }
    //Funcion mostrar Saldo en Bitcoin

    fun mostrarSaldoEnBitCoinEnElPerfilActivy(codigoDeCuentas: Int): Double? {

        var cuentaEncontrada: Double? = null

        for (cuenta in listaCuentas) {
            if (cuenta.codigoCuenta == codigoDeCuentas) {
                cuentaEncontrada = cuenta.cantidadBitcoins
                break
            }
        }
        return cuentaEncontrada
    }
    //Mostrar dashboard del perfil (nuevo 25/11)

    fun mostrarNombreDelUsuarioEnElDashboard(codigoDeCuentas: Int): String? {
        var cuentaEncontradaConNombre: String? = null

        for (cuenta in listaCuentas) {
            if (cuenta.codigoCuenta == codigoDeCuentas) {
                cuentaEncontradaConNombre = cuenta.nombre
                break
            }
        }
        return cuentaEncontradaConNombre
    }

    fun mostrarApellidooDelUsuarioEnElDashboard(codigoDeCuentas: Int): String? {
        var cuentaEncontradaConApellido: String? = null

        for (cuenta in listaCuentas) {
            if (cuenta.codigoCuenta == codigoDeCuentas) {
                cuentaEncontradaConApellido = cuenta.apellido
                break
            }
        }
        return cuentaEncontradaConApellido
    }

    fun mostrarUsuarioDellUsuarioEnElDashboard(codigoDeUsuario: Int): String? {
        var usuarioEncontradoUsuario: String? = null

        for (usuario in listaUsuario) {
            if (usuario.codigo == codigoDeUsuario) {
                usuarioEncontradoUsuario = usuario.usuario
                break
            }
        }
        return usuarioEncontradoUsuario
    }

    fun mostrarDineroDellUsuarioEnElDashboard(codigoDeUsuario: Int): String? {
        var dineroEncontradoUsuario: String? = null
        for (usuario in listaUsuario) {
            if (usuario.codigo.equals(codigoDeUsuario)) {
                for (cuenta in listaCuentas) {
                    if (cuenta.nombre == usuario.usuario) {
                        dineroEncontradoUsuario = cuenta.dineroEnCuenta.toString()

                    }
                }

            }
        }

        return dineroEncontradoUsuario
    }

    // cargamos el tipo de moneda en la compra
    fun cargarTipoDeMoneda(codigoDeCuenta: Int, tipoMoneda: String): Boolean {

        var tipoDeMoneda: String? = null
        for (compra in listaCompras) {
            if (compra.codigoCuenta.equals(codigoDeCuenta)) {
                compra.criptomoneda = tipoMoneda
                return true
            }
        }

        return false
    }

    // Agregamos saldo en bitcoins
    fun agregarSaldoEnBitcoins(
        cuenta: Cuentas,
        dineroIngresado: Double,
        monedaSelccionada: Cripto
    ): Boolean {

        if (dineroIngresado >= monedaSelccionada.valor && dineroIngresado <= cuenta.dineroEnCuenta) {

            cuenta.dineroEnCuenta = cuenta.dineroEnCuenta.minus(dineroIngresado);

            val cantidadComprada = dineroIngresado.div(monedaSelccionada.valor);

            listaCompras.add(
                Compra(
                    cuenta.codigoCuenta,
                    listaCompras.count() + 1,
                    LocalDate.now(),
                    LocalTime.now(),
                    monedaSelccionada.nombre,
                    cantidadComprada,
                    monedaSelccionada.valor
                )
            )
            MovimientosRepositorio.agregarMovimiento(
                Tickets(
                cuenta.codigoCuenta,
                listaCompras.count() + 1,
                LocalDate.now(),
                LocalTime.now(),
                monedaSelccionada.nombre,
                cantidadComprada,
                monedaSelccionada.valor
            )
            )

            for (cuentaAux in listaCuentas) {
                if (cuentaAux.codigoCuenta == cuenta.codigoCuenta) {
                    cuentaAux.dineroEnCuenta = cuenta.dineroEnCuenta;
                    cuentaAux.cantidadBitcoins = cuentaAux.cantidadBitcoins.plus(cantidadComprada)
                }
            }

            return true;
        }

        return false;
    }


}
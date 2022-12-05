package repositorios

import dataClass.Compra
import dataClass.Cripto
import dataClass.Cuentas
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period
import java.time.format.DateTimeFormatter

object CompraRepositorio {
    val compra = mutableListOf<Compra>()
    var criptos = mutableListOf<Cripto>()
    var calcularBitcoinsComprados = 0;

    init {
        criptos.add(Cripto("CriptoMas", 50.0));
        criptos.add(Cripto("CarreCripto", 50.0));
        criptos.add(Cripto("CriptpDia", 50.0))
    }

    fun agregar(compra: Compra) {
        this.compra.add(compra)
    }

    fun eliminar(compra: Compra) {
        this.compra.remove(compra)
    }

    fun obtenerPorCodigo(codigoCompra: Int): Compra {
        var encontrada: Compra = Compra(0, 0, LocalDate.now(), LocalTime.now(), "null", 0.00, 0.00)
        for (c in compra) {
            if (c.codigoCompra == codigoCompra) {
                encontrada = c
            }
        }
        return encontrada
    }

    private fun CreateLocalDate(fechaAlta: String): LocalDate {
        return LocalDate.parse(fechaAlta, DateTimeFormatter.ofPattern("yyyy-mm-dd"))
    }


}
package dataClass

import java.time.LocalDate
import java.time.LocalTime

data class Compra(
    val codigoCuenta: Int,
    val codigoCompra: Int,
    val fechaCompra: LocalDate,
    val horaCompra: LocalTime,
    var criptomoneda: String,
    var valorAdquirido: Double,
    var valorPagado: Double
)

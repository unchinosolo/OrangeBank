package clases

import java.time.LocalDate
import java.time.LocalTime

class Tickets(
    codigoCuenta: Int,
    codigoCompra: Int,
    fechaCompra: LocalDate,
    horaCompra: LocalTime,
    criptomoneda: String,
    valorAdquirido: Double,
    valorPagado: Double
) {

    var codigoCuenta: Int? = codigoCuenta
    var codigoCompra: Int? = codigoCompra
    var fechaCompra: LocalDate? = fechaCompra
    var horaCompra: LocalTime? = horaCompra
    var criptomoneda: String? = criptomoneda
    var valorAdquirido: Double? = valorAdquirido
    var valorPagado: Double? = valorPagado

}
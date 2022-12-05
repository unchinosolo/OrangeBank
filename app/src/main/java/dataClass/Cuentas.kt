package dataClass

data class Cuentas(
    val codigoCuenta: Int,
    val nombre: String,
    val apellido: String,
    var dineroEnCuenta: Double,
    val fechaAlta: String,
    var cantidadBitcoins: Double
)


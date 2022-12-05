package repositorios

import dataClass.Cuentas

object CuentaRepo {

    val cuentas = mutableListOf<Cuentas>()

    init {
        val cuenta1: Cuentas = Cuentas(1, "Luciano", "Jaime", 600.00, "2022-06-05", 0.00);
        val cuenta2: Cuentas = Cuentas(2, "Maria", "Iglesias", 80.00, "2021-06-15", 0.00);
        val cuenta3: Cuentas = Cuentas(3, "Ezequiel", "Torres", 30.00, "2022-09-18", 0.00);
        cuentas.add(cuenta1)
        cuentas.add(cuenta2)
        cuentas.add(cuenta3)
    }

}
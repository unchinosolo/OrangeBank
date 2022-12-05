package repositorios

import clases.Tickets
import java.time.LocalDate
import java.time.LocalTime

object MovimientosRepositorio {

    private val listaTickets = ArrayList<Tickets>()

    init {
        listaTickets.add(
            Tickets(2365,3321, LocalDate.now(),
                LocalTime.now(),"Criptodia",4.0,200.0)
        )
        listaTickets.add(
            Tickets(2365,3654, LocalDate.now(),
                LocalTime.now(),"Carrecripto",2.0,100.0)
        )
        listaTickets.add(
            Tickets(2365,3325, LocalDate.now(),
                LocalTime.now(),"Criptodia",8.0,400.0)
        )
        listaTickets.add(
            Tickets(2365,33256, LocalDate.now(),
                LocalTime.now(),"Criptomas",4.0,200.0)
        )
        listaTickets.add(
            Tickets(2365,35321, LocalDate.now(),
                LocalTime.now(),"Criptodia",2.0,100.0)
        )
        listaTickets.add(
            Tickets(2365,39321, LocalDate.now(),
                LocalTime.now(),"Criptomas",12.0,600.0)
        )
        listaTickets.add(
            Tickets(2365,9856, LocalDate.now(),
                LocalTime.now(),"Carrecripto",2.0,100.0)
        )
        listaTickets.add(
            Tickets(2365,3652, LocalDate.now(),
                LocalTime.now(),"Criptodia",4.0,200.0)
        )
        listaTickets.add(
            Tickets(2365,99875, LocalDate.now(),
                LocalTime.now(),"Criptodia",4.0,200.0)
        )
    }

    fun obtenerMovimientos() : List<Tickets> {
        return listaTickets
    }

    fun agregarMovimiento(movimiento : Tickets) {
        listaTickets.add(movimiento)
    }
}
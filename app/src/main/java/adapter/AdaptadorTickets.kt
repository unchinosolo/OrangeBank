package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainlogin.R
import clases.Tickets

class AdaptadorTickets(val listaTickets: List<Tickets>): RecyclerView.Adapter<AdaptadorTickets.ViewHolder>() {

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){

        val tvcodigoCuenta: TextView = ItemView.findViewById(R.id.tvCodigoUsuario)
        val tvcodigoCompra: TextView = ItemView.findViewById(R.id.tvCodigocompra)
        val tvfechaCompra: TextView = ItemView.findViewById(R.id.tvFecha)
        val tvHoraCompra: TextView = ItemView.findViewById(R.id.tvHora)
        val tvcriptomoneda: TextView = ItemView.findViewById(R.id.tvcriptomoneda)
        val tvvalorAdquirido: TextView = ItemView.findViewById(R.id.tvValorAdquirido)
        val tvvalorPagado: TextView = ItemView.findViewById(R.id.tvValorPagado)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rvtickets,parent,false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tickets = listaTickets[position]

        holder.tvcodigoCuenta.text = tickets.codigoCuenta?.toInt().toString()
        holder.tvcodigoCompra.text = tickets.codigoCompra?.toInt().toString()
        holder.tvfechaCompra.text = tickets.fechaCompra.toString()
        holder.tvHoraCompra.text = tickets.horaCompra.toString()
        holder.tvcriptomoneda.text = tickets.criptomoneda
        holder.tvvalorAdquirido.text = tickets.valorAdquirido?.toDouble().toString()
        holder.tvvalorPagado.text = tickets.valorPagado?.toDouble().toString()




    }

    override fun getItemCount(): Int {
        return listaTickets.size
    }



}
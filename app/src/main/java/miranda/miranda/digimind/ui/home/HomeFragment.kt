package miranda.miranda.digimind.ui.home

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_home.*
import miranda.miranda.digimind.Pendiente
import miranda.miranda.digimind.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var pendientes = ArrayList<Pendiente>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        cargarPendiente()
        val adapter = ColorBaseAdapter(pendientes)
        gridview.adapter = adapter

        gridview.horizontalSpacing = 15
        gridview.verticalSpacing = 15
        gridview.stretchMode = GridView.STRETCH_COLUMN_WIDTH

        return root
    }

    class ColorBaseAdapter : BaseAdapter{

        var pendientes = ArrayList<Pendiente>()

        constructor(pendientes:ArrayList<Pendiente>){
            this.pendientes = pendientes
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflater = parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val vista = inflater.inflate(R.layout.pendiente_view,null)

            var pendiente = pendientes[position]

            val titulo = vista.findViewById<TextView>(R.id.pendiente_titulo)
            val descripcion = vista.findViewById<TextView>(R.id.pendiente_descripcion)
            val hora = vista.findViewById<TextView>(R.id.pendiente_hora)
            val card = vista.findViewById<CardView>(R.id.card_view)

            titulo.text = pendiente.titulo
            descripcion.text = pendiente.descripcion
            hora.text = pendiente.hora

            card.setOnClickListener{
                Toast.makeText(parent.context,
                    "Clicked: ${pendiente.titulo}", Toast.LENGTH_SHORT).show()

            }

            return vista

        }

        override fun getItem(position: Int): Any {
            return pendientes[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return pendientes.size
        }




    }

    fun cargarPendiente(){
        pendientes.add(Pendiente("Practice 1","Everyday","17:00"))
        pendientes.add(Pendiente("Practice 2","Everyday","17:00"))
        pendientes.add(Pendiente("Practice 3","Everyday","17:00"))
        pendientes.add(Pendiente("Practice 4","Everyday","17:00"))
        pendientes.add(Pendiente("Practice 5","Everyday","17:00"))
        pendientes.add(Pendiente("Practice 6","Everyday","17:00"))
        pendientes.add(Pendiente("Practice 7","Everyday","17:00"))
        pendientes.add(Pendiente("Practice 8","Everyday","17:00"))
        pendientes.add(Pendiente("Practice 9","Everyday","17:00"))
    }

}

package co.edu.udea.compumovil.gr02_20231.lab1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import android.util.Log


class PersonalDataActivity : AppCompatActivity() {
    var txtFecha: EditText? = null
    var btnFecha: Button? = null
    var dpFecha: DatePicker? = null
    var spnGrado: Spinner? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        // DatePicker
        txtFecha = findViewById(R.id.txtFecha)
        btnFecha = findViewById(R.id.btnFecha)
        dpFecha = findViewById(R.id.dpFecha)
        txtFecha?.setText("Fecha de Nacimiento")
        dpFecha?.setOnDateChangedListener { dpFecha, anio, mes, dia ->
            txtFecha?.setText(getFechaDtePicker())
            dpFecha?.visibility = View.GONE
            btnFecha?.visibility = View.VISIBLE
        }

        //Spinner
        spnGrado=findViewById(R.id.spnGrado)
        val listaEscolaridad= arrayOf("Seleccione un grado","Primaria","Secundaria","Universitaria","Otro")
        var adaptador:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaEscolaridad)
        spnGrado?.adapter=adaptador

        //Mostrar datos en consola
        val editText = findViewById<View>(R.id.editNombre) as EditText
        val textoIngresado = editText.text.toString()
        Log.d("MiEtiqueta", "El texto ingresado es: $textoIngresado")
    }

    fun getFechaDtePicker(): String {
        var dia = dpFecha?.dayOfMonth.toString().padStart(2, '0')
        var mes = (dpFecha!!.month + 1).toString().padStart(2, '0')
        var anio = dpFecha?.year.toString().padStart(4, '0')
        return dia + "/" + mes + "/" + anio
    }

    fun muestraCalendario(view: View) {
        dpFecha?.visibility = View.VISIBLE
        btnFecha?.visibility = View.INVISIBLE
    }

    fun sigAct(view: View) {
        val intent = Intent(this, ContactDataActivity::class.java)
        startActivity(intent)
    }

}


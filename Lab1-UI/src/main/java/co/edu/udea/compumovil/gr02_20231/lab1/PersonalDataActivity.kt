package co.edu.udea.compumovil.gr02_20231.lab1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.text.TextUtils
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

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        // DatePicker
        txtFecha = findViewById(R.id.txtFecha)
        btnFecha = findViewById(R.id.btnFecha)
        dpFecha = findViewById(R.id.dpFecha)
        txtFecha?.setHint("Fecha de Nacimiento")
        dpFecha?.setOnDateChangedListener { dpFecha, anio, mes, dia ->
            txtFecha?.setText(getFechaDtePicker())
            dpFecha?.visibility = View.GONE
            btnFecha?.visibility = View.VISIBLE
        }

        //Spinner
        spnGrado=findViewById(R.id.spnGrado)
        val listaEscolaridad= arrayOf("Seleccione un grado","Primaria","Secundaria","Universitaria","Otro")
        val adaptador:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_spinner_item,listaEscolaridad)
        spnGrado?.adapter=adaptador

    }

    fun getFechaDtePicker(): String {
        val dia = dpFecha?.dayOfMonth.toString().padStart(2, '0')
        val mes = (dpFecha!!.month + 1).toString().padStart(2, '0')
        val anio = dpFecha?.year.toString().padStart(4, '0')
        return dia + "/" + mes + "/" + anio
    }

    fun muestraCalendario(view: View) {
        dpFecha?.visibility = View.VISIBLE
        btnFecha?.visibility = View.INVISIBLE
    }

    fun sigAct(view: View) {
        imprimir()
        val intent = Intent(this, ContactDataActivity::class.java)
        startActivity(intent)
    }

    fun imprimir() {
        // Obtener los objetos
        val editNombre = findViewById<EditText>(R.id.editNombre)
        val editApellidos = findViewById<EditText>(R.id.editApellidos)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val seleccion = radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(seleccion)
        val txtFecha = findViewById<EditText>(R.id.txtFecha)
        val spnGrado = findViewById<Spinner>(R.id.spnGrado)

        // Guardar textos de los objetos
        val nombre = editNombre.text.toString()
        val apellido = editApellidos.text.toString()
        val sexo = radioButton.text.toString()
        val fecha = txtFecha.text.toString()
        val grado = spnGrado.selectedItem.toString()

        // Imprimir en consola
        Log.d("IP", "Información Personal:")
        Log.d("IP", "$nombre $apellido")
        Log.d("IP", sexo)
        Log.d("IP", "Nació el $fecha")
        Log.d("IP", grado)
    }

}


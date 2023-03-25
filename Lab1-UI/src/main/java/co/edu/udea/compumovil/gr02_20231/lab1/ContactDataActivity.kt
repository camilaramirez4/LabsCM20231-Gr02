package co.edu.udea.compumovil.gr02_20231.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)

        //Autocomplete Ciudad
        val datosCiudad = arrayOf("Bogotá", "Medellín", "Cali", "Barranquilla", "Cartagena", "Cúcuta", "Ibagué", "Itaguí",
                                    "Bucaramanga", "Soledad", "Santa Marta", "Villavicencio", "Pereira", "Manizales", "Pasto",
                                    "Montería", "Neiva", "Valledupar", "Armenia", "Popayán", "Tuluá", "Envigado", "Tunja",
                                    "Florencia", "Sincelejo", "Girardot")
        val adapterCiudad = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, datosCiudad)
        val autoCompleteTextViewCiudad = findViewById<AutoCompleteTextView>(R.id.autocompleteCiudad)
        autoCompleteTextViewCiudad.setAdapter(adapterCiudad)

        //Autocomplete País
        val datosPais = arrayOf("Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Costa Rica", "Cuba",
                                "Ecuador", "El Salvador", "Guatemala", "Haití", "Honduras", "Jamaica", "México",
                                "Nicaragua", "Panamá", "Paraguay", "Perú", "Puerto Rico", "República Dominicana",
                                "Uruguay", "Venezuela")
        val adapterPais = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, datosPais)
        val autoCompleteTextViewPais = findViewById<AutoCompleteTextView>(R.id.autocompletePais)
        autoCompleteTextViewPais.setAdapter(adapterPais)
    }

    fun antAct(view: View) {
        val intent = Intent(this, PersonalDataActivity::class.java)
        startActivity(intent)
    }
}
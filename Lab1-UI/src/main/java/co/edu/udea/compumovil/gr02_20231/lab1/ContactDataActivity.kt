package co.edu.udea.compumovil.gr02_20231.lab1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

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

        val myButton = findViewById<Button>(R.id.anteriorButton)
        myButton.setOnClickListener {
            val editTextTelefono = findViewById<EditText>(R.id.editTextTelefono)
            val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
            val autocompletePais = findViewById<EditText>(R.id.autocompletePais)

            if (editTextTelefono.text.toString().isEmpty()) {
                Toast.makeText(this, "El teléfono es un campo obligatorio y está vacío.", Toast.LENGTH_SHORT).show()
            } else if (editTextEmail.text.toString().isEmpty()){
                Toast.makeText(this, "El e-mail es un campo obligatorio y está vacío.", Toast.LENGTH_SHORT).show()
            } else if (autocompletePais.text.toString().isEmpty()) {
                Toast.makeText(this, "El país es un campo obligatorio y está vacío.", Toast.LENGTH_SHORT).show()
            } else {
                imprimir()
                val intent = Intent(this, PersonalDataActivity::class.java)
                startActivity(intent)
            }

        }

    }

    fun imprimir() {
        // Obtener los objetos
        val editTextTelefono = findViewById<EditText>(R.id.editTextTelefono)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val autocompletePais = findViewById<AutoCompleteTextView>(R.id.autocompletePais)
        val autocompleteCiudad = findViewById<AutoCompleteTextView>(R.id.autocompleteCiudad)
        val editTextDireccion = findViewById<EditText>(R.id.editTextDireccion)

        // Guardar textos de los objetos
        val telefono = editTextTelefono.text.toString()
        val email = editTextEmail.text.toString()
        val pais = autocompletePais.text.toString()
        val ciudad = autocompleteCiudad.text.toString()
        val direccion = editTextDireccion.text.toString()

        // Imprimir en consola
        Log.d("IC", "Información de contacto:")
        Log.d("IC", "Teléfono: $telefono")
        Log.d("IC", "Dirección: $direccion")
        Log.d("IC", "Email: $email")
        Log.d("IC", "Pais: $pais")
        Log.d("IC", "Ciudad: $ciudad")

    }
}
package co.edu.udea.compumovil.gr02_20231.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
    }

    fun antAct(view: View) {
        val intent = Intent(this, PersonalDataActivity::class.java)
        startActivity(intent)
    }
}
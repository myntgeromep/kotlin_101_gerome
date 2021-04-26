package ph.apper.android.pagatpatan.ecommerce

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.account_registration.*

class RegisterActivity : AppCompatActivity() {

    lateinit var option : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_registration)

        btn_register.setOnClickListener{
            if (et_email.text.isEmpty()) {
                Toast.makeText(this, "Please fill-up all the fields", Toast.LENGTH_SHORT).show()
            } else if (et_password.text.isEmpty() || et_confirmpassword.text.isEmpty()) {
                Toast.makeText(this, "Please fill-up all the fields", Toast.LENGTH_SHORT).show()
            } else {
                mainPage()
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        option = findViewById(R.id.spinner_salutation) as Spinner
        var options = arrayOf(" ", "Male", "Female")
        option.adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, options)
    }

    fun mainPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
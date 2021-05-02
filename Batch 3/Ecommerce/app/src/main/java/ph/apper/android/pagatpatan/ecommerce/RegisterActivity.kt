package ph.apper.android.pagatpatan.ecommerce

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.account_registration.*
import ph.apper.android.pagatpatan.testapi.api.RetrofitClient
import ph.apper.android.pagatpatan.testapi.models.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var option : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_registration)

        btn_register.setOnClickListener{

            val email = et_email.text.toString().trim()
            val password =et_password.text.toString().trim()
            val confirmPassword = et_confirmpassword.text.toString().trim()

            if(email.isEmpty()){
                et_email.error = "Email required"
                et_email.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                et_password.error = "Password required"
                et_password.requestFocus()
                return@setOnClickListener
            }

            if(confirmPassword.isEmpty()){
                et_confirmpassword.error = "Confirm Password required"
                et_confirmpassword.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.createUser(email, password)
                .enqueue(object: Callback<DefaultResponse> {
                    override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })

        }

        option = findViewById(R.id.spinner_salutation) as Spinner
        var options = arrayOf(" ", "Male", "Female")
        option.adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, options)

        var spin = option.selectedItem.toString();
    }

    fun mainPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
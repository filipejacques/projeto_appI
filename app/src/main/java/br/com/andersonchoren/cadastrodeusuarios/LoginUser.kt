package br.com.andersonchoren.cadastrodeusuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.MenuItem
import br.com.andersonchoren.cadastrodeusuarios.databinding.ActivityAddUserBinding
import br.com.andersonchoren.cadastrodeusuarios.databinding.ActivityLoginUserBinding
import com.google.android.material.snackbar.Snackbar
import java.util.jar.Attributes.Name

class LoginUser : AppCompatActivity() {
    private lateinit var binding: ActivityLoginUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.fabCompras.setOnClickListener { view ->

            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()


            if (name.isEmpty() || email.isEmpty() || password.isEmpty() ||
               email.length < 8 || password.length < 8 || email.contains("@") || email.contains(".") ||name != name || email != email ||
                password != password  ) {
                Snackbar.make(view, "Preencha todos os campos do formulário", Snackbar.LENGTH_LONG)
                    .show()
        }else {
                binding.fabCompras.setOnClickListener {
                    val intent2 = Intent(applicationContext, compras::class.java)
                    startActivity(intent2)

                }
            }

    }

}
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
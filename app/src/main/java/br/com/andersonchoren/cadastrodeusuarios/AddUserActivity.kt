package br.com.andersonchoren.cadastrodeusuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.andersonchoren.cadastrodeusuarios.databinding.ActivityAddUserBinding
import br.com.andersonchoren.cadastrodeusuarios.model.User
import br.com.andersonchoren.cadastrodeusuarios.repository.UserRepository
import com.google.android.material.snackbar.Snackbar

class AddUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.fabSave.setOnClickListener { view ->
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            val isActive = binding.swIsActive.isChecked
            val confirmacao = binding.edtConfirmacaoDePassword.toString()
            val localizacao  = binding.edtEndereco.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() ||
                confirmacao.isEmpty() ||localizacao.isEmpty() ||
                email < "8" || password < "8" ) {
                Snackbar.make(view, "Preencha todos os campos do formulário", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val objUser = User(
                    name = name,
                    email = email,
                    password = password,
                    confirmacao = confirmacao,
                    local = localizacao,
                    isActive = isActive
                )
                val repository = UserRepository(applicationContext)
                if (repository.addUser(objUser) != 0L)
                    Snackbar.make(view, "Usuário cadastrado com sucesso!!!", Snackbar.LENGTH_LONG)
                        .show()
                else
                    Snackbar.make(view,"Lamento, não foi possível cadastrar o usuário",Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
package br.com.andersonchoren.cadastrodeusuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.andersonchoren.cadastrodeusuarios.adapter.UserAdapter
import br.com.andersonchoren.cadastrodeusuarios.databinding.ActivityMainBinding
import br.com.andersonchoren.cadastrodeusuarios.model.User
import br.com.andersonchoren.cadastrodeusuarios.repository.UserRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: UserRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repository = UserRepository(applicationContext)
        binding.rcUsers.layoutManager = LinearLayoutManager(applicationContext)
        binding.rcUsers.setHasFixedSize(true)

        binding.fabAddUser.setOnClickListener {
            val intent = Intent(applicationContext, AddUserActivity::class.java)
            startActivity(intent)

            binding.fabLogin.setOnClickListener {
               val intent1 = Intent(applicationContext, LoginUser::class.java)
               startActivity(intent1)

            }
        }


    }override fun onStart() {
        super.onStart()
        val users: List<User> = repository.findAll()
        binding.rcUsers.adapter = UserAdapter(users)
    }
}
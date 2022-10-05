package br.com.andersonchoren.cadastrodeusuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.andersonchoren.cadastrodeusuarios.databinding.ActivityComprasBinding
import br.com.andersonchoren.cadastrodeusuarios.databinding.ActivityLoginUserBinding

class compras : AppCompatActivity() {
    private lateinit var binding: ActivityComprasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprasBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
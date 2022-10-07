package br.com.andersonchoren.cadastrodeusuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.andersonchoren.cadastrodeusuarios.databinding.ActivityComprasBinding
import br.com.andersonchoren.cadastrodeusuarios.databinding.ActivityLoginUserBinding
import com.google.android.material.snackbar.Snackbar

class compras : AppCompatActivity() {
    private lateinit var binding: ActivityComprasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.fabFinalizar.setOnClickListener { view ->

            val rx = binding.cbRX.isChecked
            val ssd = binding.cbSSD.isChecked
            val armario = binding.cbArmario.isChecked
            val chinelo = binding.cbChinelo.isChecked
            val casinha = binding.cbCasinha.isChecked
            val cimento = binding.cbCimento.isChecked
            var soma = 0

            if (ssd) {
                soma += 500
            }
            if (rx) {
                soma += 700
            }
            if (armario) {
                soma += 1200
            }
            if (chinelo) {
                soma += 80
            }
            if (casinha) {
                soma += 1500
            }
            if (cimento) {
                soma += 70
            }
            Snackbar.make(view, soma.toString(), Snackbar.LENGTH_LONG)
                .show()

        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
package com.ipca.combustivel.apploja

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddProduto : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_produto)

        val editarTextoMarca = findViewById<EditText>(R.id.editarTextoMarca)
        val editarTextoSerie = findViewById<EditText>(R.id.editarTextoSerie)
        val editarTextoPreço = findViewById<EditText>(R.id.editarTextoPreço)
        val editarTextoDescriçao = findViewById<EditText>(R.id.editarTextoDescriçao)
        val editarTextoStock = findViewById<EditText>(R.id.editarTextoStock)

        val buttonFeito = findViewById<Button>(R.id.buttonFeito)

        buttonFeito.setOnClickListener{
            val intent = intent
            intent.putExtra("produto_marca", editarTextoMarca.text.toString())
            intent.putExtra("produto_serie", editarTextoSerie.text.toString())
            intent.putExtra("produto_preço", editarTextoPreço.text.toString())
            intent.putExtra("produto_Descriçao", editarTextoDescriçao.text.toString())
            intent.putExtra("produto_stock", editarTextoStock.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}
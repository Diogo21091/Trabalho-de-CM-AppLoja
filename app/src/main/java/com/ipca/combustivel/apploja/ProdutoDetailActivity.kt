package com.ipca.combustivel.apploja

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProdutoDetailActivity : AppCompatActivity()
{
    var marca : String? = null
    var serie : String? = null
    var preço : String? = null
    var descriçao : String? = null
    var stock : String? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_produto)

        val marca  : String = intent.getStringExtra("produto_marca")?:""
        val serie : String = intent.getStringExtra("produto_serie")?:""
        val preço : String = intent.getStringExtra("produto_preço")?:""
        val descriçao : String = intent.getStringExtra("produto_descriçao")?:""
        val stock : String = intent.getStringExtra("produto_stock")?:""
        val anInt = intent.getIntExtra("an_int",0)

        val textViewMarca = findViewById<TextView>(R.id.textViewMarca)
        val textViewSerie = findViewById<TextView>(R.id.textViewSerie)
        val textViewPreço = findViewById<TextView>(R.id.textViewPreço)
        val textViewDescriçao =  findViewById<TextView>(R.id.textViewDescriçao)
        val textViewStock = findViewById<TextView>(R.id.textViewStock)

        textViewMarca.text = marca
        textViewSerie.text = serie
        textViewPreço.text = preço
        textViewDescriçao.text = descriçao
        textViewStock.text = stock

    }


}
package com.ipca.combustivel.apploja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity()
{
    var produtos = arrayListOf(
        Tenis1("marca1", "serie1", "preço1", "descriçao1"),
        Tenis2("marca2", "serie2", "preço2", "descriçao2"),
        Tenis3("marca3", "serie3", "preço3", "descriçao3")
    )

    lateinit var listviewProduto : ListView
    var adapter: ProdutoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listviewProduto = findViewById(R.id.listviewProduto)
        adapter = ProdutoAdapter()
        listviewProduto.adapter = adapter

    }

}
package com.ipca.combustivel.apploja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*


class MainActivity : AppCompatActivity()
{
    var produtos = arrayListOf(
        Produto("marca1", "serie1", "preço1", "descriçao1", "stock1", R.mipmap.jogo1),
        Produto("marca2", "serie2", "preço2", "descriçao2", "stock2", R.mipmap.jogo2),
        Produto("marca3", "serie3", "preço3", "descriçao3", "stock3", R.mipmap.jogo3)
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

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        buttonAdd.setOnClickListener{
            val intent = Intent(this@MainActivity, AddProduto :: class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_PRODUTO)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_PRODUTO && resultCode == RESULT_OK)
        {
            data?.let{
                val marca = it.getStringExtra("produto_marca")?:""
                val serie = it.getStringExtra("produto_serie")?:""
                val preço = it.getStringExtra("produto_preço")?:""
                val descriçao = it.getStringExtra("produto_descriçao")?:""
                val stock = it.getStringExtra("produto_Stock")?:""



                val produto = Produto(marca, serie, preço, descriçao, stock, R.mipmap.jogo1)
                produtos.add(produto)
                adapter?.notifyDataSetChanged()

            }
        }
    }

    inner class ProdutoAdapter : BaseAdapter()
    {
        override  fun getCount(): Int
        {
            return produtos.size
        }

        override fun getItem(position: Int): Any
        {
            return produtos[position]
        }

        override fun getItemId(position: Int): Long
        {
            return produtos[position].id
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View
        {
            var rootView = layoutInflater.inflate(R.layout.produto, viewGroup, false)
            val textViewProdutoMarca = rootView.findViewById<TextView>(R.id.textViewProdutoMarca)
            val textViewProdutoSerie = rootView.findViewById<TextView>(R.id.textViewProdutoSerie)
            val textViewProdutoPreço = rootView.findViewById<TextView>(R.id.textViewProdutoPreço)
            val textViewProdutoDescriçao = rootView.findViewById<TextView>(R.id.textViewProdutoDescriçao)
            val textViewProdutoStock = rootView.findViewById<TextView>(R.id.textViewProdutoStock)
            val imageViewPhoto = rootView.findViewById<ImageView>(R.id.imageViewPhoto)

            textViewProdutoMarca.text = produtos[position].marca
            textViewProdutoSerie.text = produtos[position].serie
            textViewProdutoPreço.text = produtos[position].preço
            textViewProdutoDescriçao.text = produtos[position].descriçao
            textViewProdutoStock.text = produtos[position].stock

            produtos[position].imgRes?.let{ imageViewPhoto.setImageResource(it) }

            rootView.isClickable = true
            rootView.setOnClickListener{
                val intent = Intent(this@MainActivity, ProdutoDetailActivity::class.java)
                intent.putExtra("produto_marca", produtos[position].marca)
                intent.putExtra("produto_serie", produtos[position].serie)
                intent.putExtra("produto_preço", produtos[position].preço)
                intent.putExtra("produto_descriçao", produtos[position].descriçao)
                intent.putExtra("produto_stock", produtos[position].stock)
                intent.putExtra("an_int", 34)
                startActivity(intent)

            }

            return rootView

        }
    }

    companion object{
        const val REQUEST_CODE_ADD_PRODUTO = 1001
    }

}
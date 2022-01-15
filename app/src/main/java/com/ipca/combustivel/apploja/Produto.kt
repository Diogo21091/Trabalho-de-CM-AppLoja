package com.ipca.combustivel.apploja

class Produto {
    var id : Long=0

    var marca :String? = null
    var serie :String? = null
    var preço :String? = null
    var descriçao :String? = null
    var stock :String? = null
    var imgRes :Int? = null

    constructor(marca: String?, serie: String?, preço: String?, descriçao: String?, stock: String?, imgRes :Int?)
    {
        this.marca = marca
        this.serie = serie
        this.preço = preço
        this.descriçao = descriçao
        this.stock = stock
        this.imgRes = imgRes

    }
}
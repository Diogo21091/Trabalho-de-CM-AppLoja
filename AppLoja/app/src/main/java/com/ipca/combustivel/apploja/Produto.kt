package com.ipca.combustivel.apploja

class Produto {

    var marca :String? = null
    var serie :String? = null
    var preço :String? = null
    var descriçao :String? = null

    constructor(marca: String?, serie: String?, preço: String?, descriçao: String?)
    {
        this.marca = marca
        this.serie = serie
        this.preço = preço
        this.descriçao = descriçao

    }
}
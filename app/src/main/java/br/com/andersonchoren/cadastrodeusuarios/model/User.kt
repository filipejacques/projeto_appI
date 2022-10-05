package br.com.andersonchoren.cadastrodeusuarios.model

data class User(
    var id:Long? = null,
    val name:String,
    val email:String,
    val password:String,
    val confirmacao: String,
    val local:String,
    val isActive:Boolean
)
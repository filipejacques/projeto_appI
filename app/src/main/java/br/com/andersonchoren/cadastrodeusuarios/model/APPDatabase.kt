package br.com.andersonchoren.cadastrodeusuarios.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class APPDatabase(context:Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object{
        val DATABASE_NAME = "usersdb.db"
        val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        if( db != null){
            val sql = "CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, email TEXT, password TEXT, isActive INTEGER)"
            db.execSQL(sql)
            //db.insert("users",)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
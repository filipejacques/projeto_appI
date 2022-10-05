package br.com.andersonchoren.cadastrodeusuarios.repository

import android.content.ContentValues
import android.content.Context
import br.com.andersonchoren.cadastrodeusuarios.model.APPDatabase
import br.com.andersonchoren.cadastrodeusuarios.model.User

class UserRepository(context: Context) {
    private val db = APPDatabase(context).readableDatabase

    fun addUser(user: User): Long {
        val content = ContentValues()
        content.put("name", user.name)
        content.put("email", user.email)
        content.put("password", user.password)
        content.put("confirmacao", user.confirmacao)
        content.put("local", user.local)
        content.put("isActive", user.isActive)

        return db.insert("users", null, content)
    }

    fun updateUser(user: User): Int {
        val content = ContentValues()
        content.put("name", user.name)
        content.put("email", user.email)
        content.put("password", user.password)
        content.put("confirmacao", user.confirmacao)
        content.put("local", user.local)
        content.put("isActive", user.isActive)

        return db.update("users", content, "id=?", arrayOf(user.id.toString()))
    }

    fun deleteUser(userId: Long): Int {
        return db.delete("users", "id=?", arrayOf(userId.toString()))
    }

    fun findAll(): List<User> {
        val users = mutableListOf<User>()
        val elements = db.rawQuery("select * from users", arrayOf())
        while (elements.moveToNext()) {
            val user = User(
                id = elements.getLong(0),
                name = elements.getString(1),
                email = elements.getString(2),
                password = elements.getString(3),
                confirmacao = elements.getString(4),
                local = elements.getString(5),
                isActive = elements.getInt(6) == 1
            )
            users.add(user)

        }
        elements.close()
        return users
    }
}
package br.com.andersonchoren.cadastrodeusuarios.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.andersonchoren.cadastrodeusuarios.R
import br.com.andersonchoren.cadastrodeusuarios.model.User

class UserAdapter(private val users:List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val tvId:TextView = view.findViewById(R.id.tvID)
        val tvName:TextView = view.findViewById(R.id.tvName)
        val tvEmail:TextView = view.findViewById(R.id.tvEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvId.text = users[position].id.toString()
        holder.tvName.text = users[position].name
        holder.tvEmail.text = users[position].email
    }

    override fun getItemCount(): Int = users.size
}
package com.bugratoklu.retrofit.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bugratoklu.retrofit.Model.Post
import com.bugratoklu.retrofit.R
import com.bugratoklu.retrofit.databinding.ActivityMainBinding

class PostAdapter(private val postList: ArrayList<Post>):
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {


    fun updateList(newUpdatePosts: List<Post>){
        postList.clear()
        postList.addAll(newUpdatePosts)
        notifyDataSetChanged()
    }

    class PostViewHolder(view: View):RecyclerView.ViewHolder(view){
        val id : TextView = view.findViewById(R.id.textView1)
        val title : TextView = view.findViewById(R.id.textView2)
        val body : TextView = view.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view,parent,false)
        return PostViewHolder(view)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.id.text = postList[position].id.toString()
        holder.title.text = postList[position].title.toString()
        holder.body.text = postList[position].body.toString()
    }
    override fun getItemCount(): Int {
        return postList.size
    }


}
package com.guvyerhopkins.tsusocial.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.guvyerhopkins.tsusocial.R
import com.guvyerhopkins.tsusocial.core.MockUser

class SearchAdapter(private val searchItemClickListner: SearchItemClickListner) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private lateinit var items: List<MockUser>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_search, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(users: List<MockUser>) {
        this.items = users
        notifyDataSetChanged()
    }

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mockUser: MockUser) {
            val profileImage = itemView.findViewById<ImageView>(R.id.search_item_iv)
            val userName = itemView.findViewById<TextView>(R.id.search_item_username_tv)
            val fullName = itemView.findViewById<TextView>(R.id.search_item_fullname_tv)
            val verified = itemView.findViewById<TextView>(R.id.search_item_verified_tv)

            profileImage.load(mockUser.profilePictureUrl)
            userName.text = mockUser.username
            fullName.text = mockUser.fullName
            verified.text = mockUser.getVerifiedStatus()

            itemView.setOnClickListener { searchItemClickListner.onClick(mockUser) }
        }
    }
}

interface SearchItemClickListner {
    fun onClick(mockUser: MockUser)
}
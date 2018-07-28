package com.ahmedadelsaid.githubrepos.kotlin.ui.reboslist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmedadelsaid.githubrepos.R
import com.ahmedadelsaid.githubrepos.kotlin.GlideApp
import com.ahmedadelsaid.githubrepos.kotlin.model.User
import kotlinx.android.synthetic.main.user_view_item.view.*

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * UserViewHolder is the view holder of the user.
 */
class UserViewHolder(view: View, private val clickCallback: (userId: Long) -> Unit) : RecyclerView.ViewHolder(view) {

    fun bindTo(user: User?) {
        itemView.user_name_tv.text = user?.login
        GlideApp.with(itemView.context)
            .load(user?.avatarUrl)
            .placeholder(R.mipmap.ic_launcher)
            .into(itemView.user_avatar_iv)
        user?.let {
            itemView.user_admin_tv.text = if (user.siteAdmin) "Admin" else "Not Admin"
            itemView.setOnClickListener { clickCallback(user.id) }
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickCallback: (userId: Long) -> Unit): UserViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.user_view_item, parent, false)
            return UserViewHolder(view, clickCallback)
        }
    }

}
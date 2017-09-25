package com.mishkaowner.retrika.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mishkaowner.retrika.GlideApp
import com.mishkaowner.retrika.model.User
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by MishkaOwner on 2017-09-25.
 */
class UserViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun onBind(user : User) {
        GlideApp.with(itemView.context).load(user.avatarUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(itemView.imgView)
        itemView.name.text = user.name
    }
}
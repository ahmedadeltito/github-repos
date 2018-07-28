package com.ahmedadelsaid.githubrepos.kotlin.ui.reboslist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmedadelsaid.githubrepos.R
import com.ahmedadelsaid.githubrepos.kotlin.data.NetworkState
import com.ahmedadelsaid.githubrepos.kotlin.data.Status
import kotlinx.android.synthetic.main.item_network_state.view.*

/**
 * Created by Ahmed Adel on 27/07/2018.
 *
 * NetworkStateViewHolder is the view holder that will trigger the network state and according to it, the netwokr state
 * view holder can be binded to show retry button with friendly error message.
 */
class NetworkStateViewHolder(val view: View, private val retryCallback: () -> Unit) :
    RecyclerView.ViewHolder(view) {

    init {
        itemView.retry_loading_btn.setOnClickListener { retryCallback() }
    }

    fun bindTo(networkState: NetworkState?) {
        //error message
        itemView.error_message_tv.visibility = if (networkState?.message != null) View.VISIBLE else View.GONE

        if (networkState?.message != null)
            itemView.error_message_tv.text = networkState.message

        //loading and retry
        itemView.retry_loading_btn.visibility =
                if (networkState?.status == Status.FAILED) View.VISIBLE else View.GONE
        itemView.loading_progress_bar.visibility =
                if (networkState?.status == Status.RUNNING) View.VISIBLE else View.GONE
    }

    companion object {
        fun create(parent: ViewGroup, retryCallback: () -> Unit): NetworkStateViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.item_network_state, parent, false)
            return NetworkStateViewHolder(view, retryCallback)
        }
    }

}
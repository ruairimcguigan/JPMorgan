package com.tech.jpmorgan.ui.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tech.jpmorgan.R
import com.tech.jpmorgan.vo.Album
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.album_item_view.*

class AlbumAdapter(private var items: List<Album>?) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_item_view, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: AlbumViewHolder, position: Int) {
        viewHolder.bindTo(items?.get(position))
    }

    override fun getItemCount(): Int = items!!.size

    inner class AlbumViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindTo(album: Album?) {
            album_item_view_id.text = album?.userId.toString()
            album_item_view_title.text = album?.title
        }
    }
}

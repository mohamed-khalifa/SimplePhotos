package com.mohamedkhalifa.simplephotos.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamedkhalifa.simplephotos.R
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.util.PhotoLoader
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.photos_grid_item.*


class PhotosGridAdapter(private val context: Context, private val photos: List<PhotoUIModel>?) : RecyclerView.Adapter<PhotosGridAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.photos_grid_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photoThumbnail = photos?.get(position)?.thumbnailUrl
        photoThumbnail?.let { photoThumbnailUrl ->
            PhotoLoader.loadPhoto(context, holder.photoGridImageView, photoThumbnailUrl)
        }
    }

    override fun getItemCount(): Int {
        return photos?.size ?: 0
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer
}
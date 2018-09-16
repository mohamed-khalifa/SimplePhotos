package com.mohamedkhalifa.simplephotos.view

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.mohamedkhalifa.simplephotos.R
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.util.PhotoLoader

class PhotoPagerAdapter(private val context: Context, private val photos: List<PhotoUIModel>?) : PagerAdapter() {
    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.photos_pager_item, parent, false)
        val photoPagerView:ImageView = view.findViewById(R.id.photoPagerImageView)
        val photoOriginal = photos?.get(position)?.imageUrl
        photoOriginal?.let { photoOriginalUrl ->
            PhotoLoader.loadPhoto(context, photoPagerView, photoOriginalUrl)
        }
        parent.addView(view)
        return view
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return photos?.size ?: 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

}
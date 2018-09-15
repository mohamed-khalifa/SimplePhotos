package com.mohamedkhalifa.simplephotos.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mohamedkhalifa.simplephotos.R
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.viewmodel.PhotosViewModel
import kotlinx.android.synthetic.main.fragment_photos_grid.*


class PhotosGridFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photos_grid, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)

        photosRecyclerView.layoutManager = GridLayoutManager(context, 3)
        photosRecyclerView.itemAnimator = DefaultItemAnimator()
        val photosObserver = Observer<List<PhotoUIModel>> { photos ->
            photosRecyclerView.adapter = this.context?.let { context ->
                PhotosGridAdapter(context, photos)
            }
        }

        val errorObserver = Observer<String> {
            it?.let { errorMessage ->
                Toast.makeText(activity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.initObservers()
        viewModel.photos.observe(this, photosObserver)
        viewModel.error.observe(this, errorObserver)
        val loadDataFromCache = savedInstanceState != null
        viewModel.getPhotosList(loadDataFromCache)
    }


}

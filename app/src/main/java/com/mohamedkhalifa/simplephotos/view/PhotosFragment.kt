package com.mohamedkhalifa.simplephotos.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.viewmodel.PhotosViewModel

abstract class PhotosFragment : Fragment() {
    lateinit var viewModel: PhotosViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)

        val photosObserver = Observer<List<PhotoUIModel>> { photos ->
            photosReceived(photos)
        }

        val errorObserver = Observer<String> {
            it?.let { errorMessage ->
                errorOccurred(errorMessage)
            }

        }
        viewModel.initObservers()
        viewModel.photos.observe(this, photosObserver)
        viewModel.error.observe(this, errorObserver)
    }

    abstract fun photosReceived(photos: List<PhotoUIModel>?)
    abstract fun errorOccurred(errorMessage: String)
}
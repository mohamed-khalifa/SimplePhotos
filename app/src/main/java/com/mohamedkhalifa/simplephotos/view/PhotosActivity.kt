package com.mohamedkhalifa.simplephotos.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mohamedkhalifa.simplephotos.R
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.viewmodel.PhotosViewModel

class PhotosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        val viewModel: PhotosViewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)

        val photosObserver = Observer<List<PhotoUIModel>> {
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
        }
        val errorObserver = Observer<String> {
            it?.let { errorMessage ->
                Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show() }
        }
        viewModel.initObservers()
        viewModel.photos.observe(this, photosObserver)
        viewModel.error.observe(this, errorObserver)
        viewModel.getPhotosList(false)
    }
}

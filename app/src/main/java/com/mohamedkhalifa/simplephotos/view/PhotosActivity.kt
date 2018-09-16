package com.mohamedkhalifa.simplephotos.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mohamedkhalifa.simplephotos.R

class PhotosActivity : AppCompatActivity(), PhotosGridFragment.OnPhotoGridItemSelected {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        val photosGridFragment = PhotosGridFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.contentFrameLayout, photosGridFragment)
                .commit()
    }

    override fun onPhotoGridItemSelected(selectedPhotoIndex: Int) {
        val photosPagerFragment = PhotosPagerFragment.newInstance(selectedPhotoIndex)
        supportFragmentManager.beginTransaction()
                .add(R.id.contentFrameLayout, photosPagerFragment)
                .addToBackStack(null)
                .commit()
    }
}

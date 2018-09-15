package com.mohamedkhalifa.simplephotos.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mohamedkhalifa.simplephotos.R

class PhotosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        val photosGridFragment = PhotosGridFragment()

        supportFragmentManager.beginTransaction()
                .replace(R.id.contentFrameLayout, photosGridFragment)
                .commit()
    }
}

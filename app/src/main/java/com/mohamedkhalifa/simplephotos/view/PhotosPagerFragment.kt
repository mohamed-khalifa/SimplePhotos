package com.mohamedkhalifa.simplephotos.view


import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mohamedkhalifa.simplephotos.R
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import kotlinx.android.synthetic.main.fragment_photos_pager.*


class PhotosPagerFragment : PhotosFragment() {

    private var selectedPosition: Int = 0

    companion object {
        private const val SELECTED_POSITION = "selected position"
        fun newInstance(selectedPosition: Int): PhotosPagerFragment {
            val fragment = PhotosPagerFragment()
            val args = Bundle()
            args.putInt(SELECTED_POSITION, selectedPosition)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photos_pager, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args = arguments
        selectedPosition = args?.getInt(SELECTED_POSITION) ?: 0
        photosPagesListener()
        viewModel.getPhotosList(true)
    }

    private fun photosPagesListener() {
        photosViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                selectedPosition = position
            }
        })
    }


    override fun photosReceived(photos: List<PhotoUIModel>?) {
        if (photosViewPager.adapter == null) {
            photosViewPager.adapter = this.context?.let { context ->
                PhotoPagerAdapter(context, photos)
            }
        } else {
            photosViewPager.adapter?.notifyDataSetChanged()
        }
        photosViewPager.currentItem = selectedPosition
    }

    override fun errorOccurred(errorMessage: String) {
        Toast.makeText(activity, errorMessage, Toast.LENGTH_SHORT).show()
    }

}

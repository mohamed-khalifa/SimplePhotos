package com.mohamedkhalifa.simplephotos.view

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mohamedkhalifa.simplephotos.R
import com.mohamedkhalifa.simplephotos.model.PhotoUIModel
import com.mohamedkhalifa.simplephotos.viewmodel.PhotosViewModel
import kotlinx.android.synthetic.main.fragment_photos_grid.*


class PhotosGridFragment : PhotosFragment() {
    private var isLoading = false
    var photoGridSelectedListener: OnPhotoGridItemSelected? = null

    companion object {
        fun newInstance(): PhotosGridFragment {
            val fragment = PhotosGridFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photos_grid, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnPhotoGridItemSelected) photoGridSelectedListener = context
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = GridLayoutManager(context, 3)
        photosRecyclerView.layoutManager = layoutManager
        photosRecyclerView.itemAnimator = DefaultItemAnimator()
        photosPagination(viewModel, layoutManager)
    }

    private fun photosPagination(viewModel: PhotosViewModel, layoutManager: GridLayoutManager) {
        photosRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                if (visibleItemCount + pastVisibleItems >= totalItemCount && !isLoading) {
                    viewModel.getPhotosList(false)
                    isLoading = true
                }
            }

        })
        viewModel.getPhotosList(false)
    }

    override fun photosReceived(photos: List<PhotoUIModel>?) {
        if (photosRecyclerView.adapter == null) {
            photosRecyclerView.adapter = this.context?.let { context ->
                PhotosGridAdapter(context, photos, photoGridSelectedListener)
            }
        } else {
            photosRecyclerView.adapter?.notifyDataSetChanged()
        }
        isLoading = false
    }

    override fun errorOccurred(errorMessage: String) {
        Toast.makeText(activity, errorMessage, Toast.LENGTH_SHORT).show()
        isLoading = false
    }

    interface OnPhotoGridItemSelected {
        fun onPhotoGridItemSelected(selectedPhotoIndex: Int)
    }


}

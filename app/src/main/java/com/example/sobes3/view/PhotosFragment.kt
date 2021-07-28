package com.example.sobes3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.sobes3.adapters.ListPicturesAdapter
import com.example.sobes3.adapters.PictureComparator
import com.example.sobes3.databinding.FragmentPhotosBinding
import com.example.sobes3.viewmodel.PhotosViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class PhotosFragment: Fragment(R.layout.fragment_photos) {

    private val viewModel: PhotosViewModel by viewModel()
    lateinit var binding: FragmentPhotosBinding
    lateinit var adapter: ListPicturesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotosBinding.bind(view)

        adapter = ListPicturesAdapter(PictureComparator)

        binding.recycle.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel
                .pictures
                .collectLatest { pagingData ->
                    adapter.submitData(pagingData)
                }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}
package com.example.sobes3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.sobes3.adapters.ListPicturesAdapter
import com.example.sobes3.databinding.FragmentPhotosBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel


class PhotosFragment : Fragment(R.layout.fragment_photos) {

    private val viewModel: PhotosViewModel by viewModel()
    lateinit var binding: FragmentPhotosBinding
    private lateinit var adapter: ListPicturesAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotosBinding.bind(view)

        viewModel.subscribe().observe(viewLifecycleOwner, {

        })

        lifecycleScope.launch {
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
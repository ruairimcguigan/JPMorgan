package com.tech.jpmorgan.ui.album

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tech.jpmorgan.R
import com.tech.jpmorgan.injection.Injectable
import com.tech.jpmorgan.ui.viewmodel.ViewModelFactory
import javax.inject.Inject

class AlbumFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AlbumViewModel


    companion object {
        fun newInstance() = AlbumFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.album_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(AlbumViewModel::class.java)

        if (viewModel != null) {
            Log.d(javaClass.simpleName, "all good")
        } else {
            Log.d(javaClass.simpleName, "not good")
        }
    }

//    override fun onV(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
////        viewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
////        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AlbumViewModel::class.java)
//        viewModel = ViewModelProviders.of(this, viewModelFactory)
//            .get(AlbumViewModel::class.java)
//
//        if (viewModel != null) {
//            Log.d(javaClass.simpleName, "all good")
//        } else {
//            Log.d(javaClass.simpleName, "not good")
//        }
//    }

}

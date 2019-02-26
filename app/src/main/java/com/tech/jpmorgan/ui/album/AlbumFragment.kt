package com.tech.jpmorgan.ui.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.tech.jpmorgan.R
import com.tech.jpmorgan.injection.Injectable
import com.tech.jpmorgan.vo.Album
import kotlinx.android.synthetic.main.album_fragment.*
import javax.inject.Inject

class AlbumFragment : Fragment(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: AlbumViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.album_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AlbumViewModel::class.java)
        fetchAlbums()
    }

    private fun fetchAlbums(){
        viewModel.fetchAlbums().observe(viewLifecycleOwner, Observer { repos ->
                repos.data?.let {
                    setAlbumList(it)
                }
        })
    }

    private fun setAlbumList(data: List<Album>) = with(album_list) {
        adapter = AlbumAdapter(data.sortedWith(compareBy(Album::title)))
        layoutManager = LinearLayoutManager(activity)
        addItemDecoration(DividerItemDecoration(activity, VERTICAL))
        setHasFixedSize(true)
    }
}

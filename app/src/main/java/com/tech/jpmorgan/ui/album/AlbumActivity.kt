package com.tech.jpmorgan.ui.album

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tech.jpmorgan.R

class AlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.album_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AlbumFragment.newInstance())
                .commitNow()
        }
    }

}

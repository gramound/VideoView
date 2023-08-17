package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    private lateinit var mVideoView: VideoView
    private lateinit var mButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        mVideoView = findViewById(R.id.videoView)
        mButton = findViewById(R.id.button)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
        mVideoView.stopPlayback()
        mButton.visibility = View.VISIBLE
        mVideoView.visibility = View.GONE
    }

    fun start(view: View) {
        view.visibility = View.GONE
        mVideoView.visibility = View.VISIBLE
        Log.d(TAG, "setVideoURI")
        mVideoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video))
        mVideoView.setOnCompletionListener {
            mButton.visibility = View.VISIBLE
            mVideoView.visibility = View.GONE
        }
        Log.d(TAG, "start")
        mVideoView.start()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "stopPlayback")
        mVideoView.stopPlayback()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
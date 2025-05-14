package com.tuno_appsmusic.features.onboarding.presentation.widgets

import android.graphics.Matrix
import android.graphics.SurfaceTexture
import android.net.Uri
import android.view.Surface
import android.view.TextureView
import android.view.TextureView.SurfaceTextureListener
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer

@UnstableApi
@Composable
fun NativeVideoBackground() {
    val context = LocalContext.current

    val exoPlayer = remember(context) {
        ExoPlayer.Builder(context).build().apply {
            val uri = Uri.parse("android.resource://${context.packageName}/raw/tuno_onboarding_720")
            val mediaItem = MediaItem.fromUri(uri)
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
            repeatMode = ExoPlayer.REPEAT_MODE_ALL
            volume = 0f
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = {
            object : TextureView(it) {
                init {
                    surfaceTextureListener = object : SurfaceTextureListener {
                        override fun onSurfaceTextureAvailable(
                            surfaceTexture: SurfaceTexture,
                            width: Int,
                            height: Int
                        ) {
                            val surface = Surface(surfaceTexture)
                            exoPlayer.setVideoSurface(surface)

                            // CenterCrop fix (Matrix Scaling)
                            val videoWidth = exoPlayer.videoFormat?.width ?: return
                            val videoHeight = exoPlayer.videoFormat?.height ?: return

                            val viewRatio = width.toFloat() / height
                            val videoRatio = videoWidth.toFloat() / videoHeight

                            val matrix = Matrix()

                            if (videoRatio > viewRatio) {
                                // Video lebih lebar
                                val scale = height.toFloat() / videoHeight
                                val scaledWidth = videoWidth * scale
                                val dx = (width - scaledWidth) / 2
                                matrix.setScale(scale, scale)
                                matrix.postTranslate(dx, 0f)
                            } else {
                                // Video lebih tinggi
                                val scale = width.toFloat() / videoWidth
                                val scaledHeight = videoHeight * scale
                                val dy = (height - scaledHeight) / 2
                                matrix.setScale(scale, scale)
                                matrix.postTranslate(0f, dy)
                            }

                            setTransform(matrix)
                            invalidate()
                        }

                        override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {}
                        override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
                            exoPlayer.setVideoSurface(null)
                            return true
                        }

                        override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {}
                    }
                }
            }.apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }
    )
}

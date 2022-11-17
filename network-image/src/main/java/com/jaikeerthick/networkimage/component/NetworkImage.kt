
package com.jaikeerthick.networkimage.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

/**
 * [NetworkImage] is a composable which uses [Koil] library under the hood to display
 * images from remote source with Loading, Error and Empty states handled out of the box
 */
@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    url: String?,
    contentDescription: String? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = 1f,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = FilterQuality.Medium,
){
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        filterQuality = filterQuality,
    ) {

        when(painter.state){

            is AsyncImagePainter.State.Loading -> {
                NetworkImageLoader()
            }
            is AsyncImagePainter.State.Error -> {
                NetworkImageError()
            }
            is AsyncImagePainter.State.Success -> {
                SubcomposeAsyncImageContent()
            }
            AsyncImagePainter.State.Empty -> {
                NetworkImageEmpty()
            }
        }

    }

}